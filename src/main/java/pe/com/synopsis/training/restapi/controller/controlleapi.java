package pe.com.synopsis.training.restapi.controller;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.synopsis.client.soap.WsCountryClient;
import io.spring.guides.gs_producing_web_service.Country;

@RestController
@RequestMapping("/country")
public class controlleapi {
	@Autowired
	public WsCountryClient client;
	@GetMapping("/findbyname")
	public GetCountryResponse name(@RequestParam(name = "pais", required = false, defaultValue = "NULL") String pais) {
		GetCountryResponse respuesta = client.findByName(pais);
		return respuesta;
	}

	@PostMapping ("/findbyname2/{pais}")
	public GetCountryResponse name2(@PathVariable("pais") String pais) {
		GetCountryResponse respuesta2 = client.findByName(pais);
		return respuesta2;
	}
	
}
