package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.guides.gs_producing_web_service.Country;
import pe.com.synopsis.client.soap.WsCountryClient;

@RestController
@RequestMapping("/country")
public class FindByNameController {
	
	@Autowired
	public WsCountryClient client;
	
	@GetMapping("/findbyname")
	@ResponseBody
	public Country getFindByName(@RequestParam(required = true) String name) {
		Country country = client.findByName(name).getCountry();
		
		return country;
	}
	
	@PostMapping("/findbyname")
	public Country postFindByName(@RequestParam String name ) {
		Country country = client.findByName(name).getCountry();
		
		return country;
	}
	
	
	

	
	
//	@GetMapping("/findByName/findByName")
//	@ResponseBody
//	public Country getFindByName(@RequestParam(required = false) String name) {}
}
