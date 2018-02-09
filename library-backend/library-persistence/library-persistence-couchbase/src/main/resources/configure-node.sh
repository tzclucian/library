set -x
set -m

/entrypoint.sh couchbase-server &

# Sleep after starting Couchbase server
# Setup index and memory quota
until $(curl -v -X POST http://127.0.0.1:8091/pools/default -d memoryQuota=300 -d indexMemoryQuota=300); do
    # This request is tried until it succeeds
    echo "[INFO] Waiting 5 more seconds until couchbase is up..."
    sleep 5
done

# Setup services
echo "[INFO] Setting up services"
curl -v http://127.0.0.1:8091/node/controller/setupServices -d services=kv%2Cn1ql%2Cindex

# Setup credentials
echo "[INFO] Setting up credentials"
curl -v http://127.0.0.1:8091/settings/web -d port=8091 -d username=libraryUser -d password=libraryPassword

# Setup Memory Optimized Indexes
echo "[INFO] Setting up index"
 curl -X POST -i -H "Authorization: Basic bGlicmFyeVVzZXI6bGlicmFyeVBhc3N3b3Jk"  http://127.0.0.1:8091/settings/indexes -d 'storageMode=memory_optimized'

# Create bucket with username and password
curl -X POST -H "Authorization: Basic bGlicmFyeVVzZXI6bGlicmFyeVBhc3N3b3Jk" -d name=libraryBucket -d ramQuotaMB=200 -d authType=sasl -d saslPassword=libraryPassword -d replicaNumber=1 http://localhost:8091/pools/default/buckets

sleep 17

# Sleep a little bit more so the data is succesfully inserted
echo "[INFO] Waiting for data to be inserted..."
sleep 5

# Sleep so the index can be available
sleep 10

echo "Type: $TYPE"

if [ "$TYPE" = "WORKER" ]; then
  echo "Sleeping ..."
  sleep 15

  #IP=`hostname -s`
  IP=`hostname -I | cut -d ' ' -f1`
  echo "IP: " $IP

  echo "Auto Rebalance: $AUTO_REBALANCE"
  if [ "$AUTO_REBALANCE" = "true" ]; then
    couchbase-cli rebalance --cluster=$COUCHBASE_MASTER:8091 --user=libraryUser --password=libraryPassword --server-add=$IP --server-add-username=libraryUser --server-add-password=libraryPassword
  else
    couchbase-cli server-add --cluster=$COUCHBASE_MASTER:8091 --user=libraryUser --password=libraryPassword --server-add=$IP --server-add-username=libraryUser --server-add-password=libraryPassword
  fi;
fi;

fg 1
