package pe.com.synopsis.training.restapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.synopsis.training.restapi.bean.request.AddCountryRequest;
import pe.com.synopsis.training.restapi.bean.request.CountryRequest;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.bean.response.base.GenResponse;import pe.com.synopsis.training.restapi.bean.response.base.Status;
import pe.com.synopsis.training.restapi.enumerations.StatusEnum;
import pe.com.synopsis.training.restapi.exception.CountryException;
import pe.com.synopsis.training.restapi.service.CountryService;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService service;

    @GetMapping("/findbyname")
    public ResponseEntity<?> findByNameGet(CountryRequest value) throws CountryException {
        CountryResponse data = service.findByName(value.getName());
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/findbyname")
    public ResponseEntity<?> findByNamePost(@RequestBody CountryRequest value) throws CountryException {
        CountryResponse data = service.findByName(value.getName());
        return ResponseEntity.ok().body(GenResponse.builder().status(StatusEnum.OK.getStatus()).data(data).build());
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() throws CountryException {
        List<CountryResponse> data = service.getAllCountries();
        return ResponseEntity.ok().body(GenResponse.builder().status(StatusEnum.OK.getStatus()).data(data).build());
    }
    
    @PostMapping("/addCountry")
    public ResponseEntity<?> addCountry(@RequestBody AddCountryRequest request) throws CountryException {
        service.addCountry(request.getName(), request.getPopulation(), request.getCapital(), request.getCurrency());
        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build());
    }
}
