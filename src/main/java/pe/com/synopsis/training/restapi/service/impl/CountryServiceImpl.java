package pe.com.synopsis.training.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.synopsis.client.soap.WsCountryClient;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.converter.CountryConverter;
import pe.com.synopsis.training.restapi.exception.CountryException;
import pe.com.synopsis.training.restapi.service.CountryService;
import ws.synopsis.guides.gs_producing_web_service.AddCountryResponse;
import ws.synopsis.guides.gs_producing_web_service.Country;
import ws.synopsis.guides.gs_producing_web_service.Currency;
import ws.synopsis.guides.gs_producing_web_service.GetCountriesResponse;
import ws.synopsis.guides.gs_producing_web_service.GetCountryResponse;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryConverter converter;
    private final WsCountryClient client;

    @Override
    public CountryResponse findByName(String value) throws CountryException {
        GetCountryResponse respWs = client.findByName(value);
        if(respWs.getCountry() == null){
            throw new CountryException();
        }
        return converter.convert(respWs.getCountry());
    }

	@Override
	public List<CountryResponse> getAllCountries() throws CountryException {
		GetCountriesResponse respWS = client.getCountries();
		if(respWS.getCountriesvalues() == null) {
			throw new CountryException();
		}
		List<CountryResponse> listCountries = new ArrayList<CountryResponse>();
		for(Country country: respWS.getCountriesvalues()) {
			listCountries.add(converter.convert(country));
		}
		return listCountries;
	}

	@Override
	public void addCountry(String name, int population, String capital, String currency) throws CountryException{
		try {
			AddCountryResponse respWS = client.addCountry(name, population, capital, Currency.fromValue(currency));
		}catch (Exception CountryException){
			throw new CountryException();
		}
				
	}
}
