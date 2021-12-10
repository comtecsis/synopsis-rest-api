package pe.com.synopsis.training.restapi.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import pe.com.synopsis.client.soap.WsCountryClient;
import pe.com.synopsis.training.restapi.repository.CountryRepository;
import ws.synopsis.guides.gs_producing_web_service.Country;
import ws.synopsis.guides.gs_producing_web_service.GetCountriesResponse;
import ws.synopsis.guides.gs_producing_web_service.GetCountryResponse;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SoapCountryRepositoryImpl implements CountryRepository {

    private final WsCountryClient client;

    @Override
    public Optional<Country> findByName(String name) {
        GetCountryResponse response = client.findByName(name);
        Country foundCountry = response.getCountry();
        return Optional.ofNullable(foundCountry);
    }

    @Override
    public List<Country> findAll() {
        GetCountriesResponse response = client.findAll();
        return response.getCountriesvalues();
    }

    @Override
    public boolean save(Country country) {
        client.save(country);
        return true;
    }

    @Override
    public boolean update(Country country) {
        client.update(country);
        return true;
    }

    @Override
    public boolean remove(String name) {
        client.remove(name);
        return true;
    }
}
