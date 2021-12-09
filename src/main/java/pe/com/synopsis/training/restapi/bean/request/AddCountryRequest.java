package pe.com.synopsis.training.restapi.bean.request;

import java.io.Serializable;

import lombok.Data;
import ws.synopsis.guides.gs_producing_web_service.Currency;

@Data
public class AddCountryRequest implements Serializable {
	private String name;
	private int population;
	private String capital;
	private String currency;
}
