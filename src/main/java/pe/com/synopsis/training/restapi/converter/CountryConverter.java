package pe.com.synopsis.training.restapi.converter;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;

import java.util.UUID;

@Component
public class CountryConverter implements Converter<Country, CountryResponse> {
    @Override
    public CountryResponse convert(Country source) {
        CountryResponse target = new CountryResponse();
        target.setCurrencyWeb(source.getCurrency().value());
        target.setCapitalWeb(source.getCapital());
        target.setNameWeb(source.getName());
        target.setPopulationWeb(source.getPopulation());
        target.setUuid(UUID.randomUUID().toString());
        return target;
    }
}
