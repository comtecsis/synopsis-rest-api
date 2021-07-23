package pe.com.synopsis.training.restapi;

import io.spring.guides.gs_producing_web_service.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.com.synopsis.client.soap.WsCountryClient;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	// @Autowired
	// public WsCountryClient client;

	// @Override
	// public void run(String... args) throws Exception {
	// 	System.out.println("Resultado:");
	//  Country country = client.findByName(args[0]).getCountry();
	// 	System.out.println("Capital: " + country.getCapital());
	// }

	
}
