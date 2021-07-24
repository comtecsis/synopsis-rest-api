package pe.com.synopsis.training.restapi.service;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.synopsis.client.soap.WsCountryClient;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.converter.CountryConverter;
import pe.com.synopsis.training.restapi.exception.CountryException;

public interface CountryService {

    public CountryResponse findByName(String value) throws CountryException;

}
