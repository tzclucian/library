package tzc.library;

import org.springframework.stereotype.Service;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Service
public class ConnectionThatListens {
    private String serverIp;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public void listen() {
        System.out.println("am inceput sa ascult pentru schimbari la ip-ul" + serverIp);
    }
}
