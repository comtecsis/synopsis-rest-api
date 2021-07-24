package pe.com.synopsis.training.restapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.synopsis.training.restapi.bean.request.CountryRequest;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
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
        return ResponseEntity.ok().body(data);
    }

}
