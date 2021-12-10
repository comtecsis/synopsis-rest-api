package pe.com.synopsis.training.restapi.repository;

import ws.synopsis.guides.gs_producing_web_service.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    Optional<Country> findByName(String name);
    List<Country> findAll();
    boolean save(Country country);
    boolean update(Country country);
    boolean remove(String name);
}
