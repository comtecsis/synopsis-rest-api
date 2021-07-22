package pe.com.synopsis.training.restapi.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pe.com.synopsis.client.soap.WsCountryClient;

@Configuration
@AllArgsConstructor
public class WsConfig {

    @Bean
    public WsCountryClient wsCountryClient(WebServiceTemplate template, @Value("${country.ws.url}") String url) {
        return new WsCountryClient(template, url, new SoapActionCallback(""));
    }

}
