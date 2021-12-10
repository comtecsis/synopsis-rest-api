package pe.com.synopsis.training.restapi.service.impl;

;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.synopsis.training.restapi.bean.request.CountryRequest;
import pe.com.synopsis.training.restapi.bean.response.CountryCollectionResponse;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.converter.CountryCollectionConverter;
import pe.com.synopsis.training.restapi.converter.CountryConverter;
import pe.com.synopsis.training.restapi.exception.CountryException;
import pe.com.synopsis.training.restapi.repository.CountryRepository;
import pe.com.synopsis.training.restapi.service.CountryService;
import ws.synopsis.guides.gs_producing_web_service.Country;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryConverter converter;
    private final CountryCollectionConverter countryCollectionConverter;
    private final CountryRepository countryRepositpry;

    @Override
    public CountryResponse getByName(String name) throws CountryException {
        Optional<Country> countryOptional = countryRepositpry.findByName(name);

        if (!countryOptional.isPresent()) {
            throw new CountryException();
        }
        return converter.convert(countryOptional.get());
    }

    @Override
    public CountryCollectionResponse getAll() throws CountryException {
        List<Country> countriesList = countryRepositpry.findAll();
        return countryCollectionConverter.convert(countriesList);
    }

    @Override
    public CountryResponse add(CountryRequest request) throws CountryException {
        Country countryToSave = new Country();
            countryToSave.setName(request.getName());
            countryToSave.setPopulation(request.getPopulation());
            countryToSave.setCapital(request.getCapital());
            countryToSave.setCurrency(request.getCurrency());
        countryRepositpry.save(countryToSave);
        return new CountryResponse();
    }

    @Override
    public CountryResponse update(CountryRequest request) throws CountryException {
        Country countryToUpdate = new Country();
            countryToUpdate.setName(request.getName());
            countryToUpdate.setPopulation(request.getPopulation());
            countryToUpdate.setCapital(request.getCapital());
            countryToUpdate.setCurrency(request.getCurrency());
        countryRepositpry.update(countryToUpdate);
        return new CountryResponse();
    }

    @Override
    public CountryResponse delete(String name) throws CountryException {
        countryRepositpry.remove(name);
        return new CountryResponse();
    }
}
