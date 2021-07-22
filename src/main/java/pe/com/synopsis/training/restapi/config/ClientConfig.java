package pe.com.synopsis.training.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class ClientConfig {

    @Value("${connection.timeout}")
    private String connectionTimeout;

    @Value("${read.timeout}")
    private String readTimeout;

    @Value("${max.total.Connections}")
    private String maxTotalConnections;

    @Bean
    public Jaxb2Marshaller marshaller()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("io.spring.guides.*");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate wsTemplate()
    {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(marshaller());
        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        sender.setConnectionTimeout(Integer.valueOf(connectionTimeout));
        sender.setReadTimeout(Integer.valueOf(readTimeout));
        sender.setMaxTotalConnections(Integer.valueOf(maxTotalConnections));
        webServiceTemplate.setMessageSender(sender);
        return webServiceTemplate;
    }
}
