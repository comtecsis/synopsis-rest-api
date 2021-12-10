package pe.com.synopsis.training.restapi.service;

import pe.com.synopsis.training.restapi.bean.request.CountryRequest;
import pe.com.synopsis.training.restapi.bean.response.CountryCollectionResponse;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.exception.CountryException;
import ws.synopsis.guides.gs_producing_web_service.Country;

public interface CountryService {

    CountryResponse getByName(String name) throws CountryException;
    CountryCollectionResponse getAll() throws CountryException;
    CountryResponse add(CountryRequest request) throws CountryException;
    CountryResponse update(CountryRequest request) throws CountryException;
    CountryResponse delete(String name) throws CountryException;



}
