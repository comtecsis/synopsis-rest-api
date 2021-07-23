package pe.com.synopsis.training.restapi.controller;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pe.com.synopsis.client.soap.WsCountryClient;
import pe.com.synopsis.training.restapi.converter.CountryConverse;
import pe.com.synopsis.training.restapi.model.CountryModel;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static Log LOG = LogFactory.getLog(CountryController.class);

    @Autowired
    public WsCountryClient client;

    @Autowired
    @Qualifier("countryConverter")
    public CountryConverse countryConverse;

    @GetMapping(value = "/{name}")
    public CountryModel getCountryGet(@PathVariable("name") String name)
    {
        Country country = client.findByName(name).getCountry();
        LOG.info(countryConverse.responseToModel(country));
        return countryConverse.responseToModel(country);
    }
    /*public GetCountryResponse getCountryGet(@PathVariable("name") String name)
    {
        GetCountryResponse country = client.findByName(name);
        return country;
    }*/

    @PostMapping()
    public CountryModel getCountryPost(@ModelAttribute("name") String name)
    {
        Country country = client.findByName(name).getCountry();
        return countryConverse.responseToModel(country);
    }
    /*public GetCountryResponse getCountryPost(@ModelAttribute("name") String name)
    {
        LOG.info(name);
        GetCountryResponse country = client.findByName(name);
        return country;
    }*/

}
