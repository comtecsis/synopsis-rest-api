package pe.com.synopsis.training.restapi.service.impl;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.synopsis.client.soap.WsCountryClient;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.converter.CountryConverter;
import pe.com.synopsis.training.restapi.exception.CountryException;
import pe.com.synopsis.training.restapi.service.CountryService;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryConverter converter;
    private final WsCountryClient client;

    @Override
    public CountryResponse findByName(String value) throws CountryException {
        GetCountryResponse respWs = client.getCountry(value);
        if(respWs.getCountry() == null){
            throw new CountryException();
        }
        return converter.convert(respWs.getCountry());
    }
}
