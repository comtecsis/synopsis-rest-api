package pe.com.synopsis.training.restapi.converter;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.stereotype.Component;
import pe.com.synopsis.training.restapi.model.CountryModel;

@Component("countryConverter")
public class CountryConverse {

    public CountryModel responseToModel(Country country)
    {
        try {
            CountryModel countryModel = new CountryModel();
            countryModel.setName(country.getName());
            countryModel.setPopulation(country.getPopulation());
            countryModel.setCapital(country.getCapital());
            countryModel.setCurrency(country.getCurrency().toString());

            return countryModel;
        }catch (Exception e)
        {
            CountryModel countryModel = new CountryModel();
            countryModel.setName("");
            countryModel.setPopulation(0);
            countryModel.setCapital("");
            countryModel.setCurrency("");
            return countryModel;
        }
    }

}
