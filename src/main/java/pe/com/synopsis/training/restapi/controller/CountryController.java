package pe.com.synopsis.training.restapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.synopsis.training.restapi.bean.request.CountryRequest;
import pe.com.synopsis.training.restapi.bean.response.CountryCollectionResponse;
import pe.com.synopsis.training.restapi.bean.response.CountryResponse;
import pe.com.synopsis.training.restapi.exception.CountryException;
import pe.com.synopsis.training.restapi.service.CountryService;
import ws.synopsis.guides.gs_producing_web_service.Country;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService service;

    @GetMapping("/{name}")
    public ResponseEntity<?> getOneByName(@PathVariable String name) throws CountryException {
        CountryResponse data = service.getByName(name);
        return ResponseEntity.ok().body(data);
    }
    @GetMapping("/")
    public ResponseEntity<?> listAll() throws CountryException {
        CountryCollectionResponse data = service.getAll();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody CountryRequest request) throws CountryException {
        CountryResponse data = service.add(request);
        return ResponseEntity.ok().body(data);
    }
    @PutMapping("/{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody CountryRequest request) throws CountryException {
        request.setName(name);
        CountryResponse data = service.update(request);
        return ResponseEntity.ok().body(data);
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<?> update(@PathVariable String name) throws CountryException {
        CountryResponse data = service.delete(name);
        return ResponseEntity.ok().body(data);
    }

}
