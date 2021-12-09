package pe.com.synopsis.training.restapi.service;

import java.util.List;

import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.exception.CountryException;
import ws.synopsis.guides.gs_producing_web_service.Currency;

public interface CountryService {

    public CountryResponse findByName(String value) throws CountryException;
    public List<CountryResponse> getAllCountries() throws CountryException;
    public void addCountry(String name, int population, String capital, String currency) throws CountryException;
}
