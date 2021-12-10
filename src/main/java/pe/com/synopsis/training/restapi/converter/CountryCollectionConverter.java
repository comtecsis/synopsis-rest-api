package pe.com.synopsis.training.restapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pe.com.synopsis.training.restapi.bean.response.CountryCollectionResponse;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import ws.synopsis.guides.gs_producing_web_service.Country;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CountryCollectionConverter implements Converter<List<Country>, CountryCollectionResponse> {

    private final CountryConverter countryConverter;

    @Override
    public CountryCollectionResponse convert(List<Country> source) {
        CountryCollectionResponse countryCollectionResponse = new CountryCollectionResponse();

        countryCollectionResponse.setCountries(
                source.stream()
                        .map(countryConverter::convert)
                        .collect(Collectors.toList())
        );

        return countryCollectionResponse;
    }
}
