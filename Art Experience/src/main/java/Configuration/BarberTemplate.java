package Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "barber")
public class BarberTemplate {

        private String SomeBarberList_Clients;

        public String getSomeBarberList_Clients(){return SomeBarberList_Clients;}

        public void setSomeBarberList_Clients(String SomeBarber_Clients){this.SomeBarberList_Clients = SomeBarber_Clients;}

        @Bean (name = "barberTemplate")
        public RestTemplate getRestTemplate(){return new RestTemplate();}
}
