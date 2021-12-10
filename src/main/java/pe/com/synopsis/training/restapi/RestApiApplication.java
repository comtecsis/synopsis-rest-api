package pe.com.synopsis.training.restapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.com.synopsis.client.soap.WsCountryClient;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(WsCountryClient client){
        return args -> {
          client.findAll().getCountriesvalues().forEach(country -> System.out.println(country.getName()));
            //System.out.println(client.findAll().getCountry().getName());;
        };
    }

}
