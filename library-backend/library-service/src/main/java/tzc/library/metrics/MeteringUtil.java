package tzc.library.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;

@Component
public class MeteringUtil
{
    @Autowired
    ApplicationContext context;

    @Autowired
    private MeterRegistry meterRegistry;

    // successful REST calls to the target Alfresco server
    // this usually means status codes like 200 or 201
    private volatile Counter restCallsSuccessful;

    // measure number or requests made each second by the bm framework
    // each second may be too small of an interval. we may consider minute
    private volatile Gauge numberOfRequestsPerTime;

    private volatile AtomicInteger numberOfRequestsPerSecond = new AtomicInteger();


    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        System.out.println("We are initializing MeteringUtil now!!!!!!");

        restCallsSuccessful = meterRegistry.counter("rest.calls.successful");

        final ToDoubleFunction<AtomicInteger> toDoubleFunction = new ToDoubleFunction<AtomicInteger>()
        {
            @Override
            public double applyAsDouble(AtomicInteger value)
            {
                return value.doubleValue();
            }
        };
        numberOfRequestsPerTime = Gauge.builder("number.requests.per.time", numberOfRequestsPerSecond, toDoubleFunction).register(meterRegistry);
    }

    public Counter getRestCallsSuccessful()
    {
        return restCallsSuccessful;
    }

    private Set<Long> events = new HashSet();

    public synchronized void registerCall()
    {
        final long tNow = System.currentTimeMillis();
        events.add(tNow);
        //quick clean
        final Long tASecondAgo = tNow - 1000;
        for (Long t : events.toArray(new Long[events.size()]))
        {
            if (t.compareTo(tASecondAgo) < 0)
            {
                events.remove(t);
            }
        }
        numberOfRequestsPerSecond.set(events.size());
        System.out.println("Registered a call... ");
    }

}
