package pe.com.synopsis.training.restapi.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import ws.synopsis.guides.gs_producing_web_service.Country;

import java.util.UUID;

@Component
public class CountryConverter implements Converter<Country, CountryResponse> {
    @Override
    public CountryResponse convert(Country source) {
        CountryResponse target = CountryResponse.builder()
                .nameWeb(source.getName())
                .populationWeb(source.getPopulation())
                .capitalWeb(source.getCapital())
                .currencyWeb(source.getCurrency().name())
                .uuid(UUID.randomUUID().toString())
                .build();
        return target;
    }
}
