import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        String hostname = "";

    try {
            InetAddress myHost = InetAddress.getLocalHost();
            hostname =  "Hostname " + (myHost.getHostName());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        
        return hostname;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
