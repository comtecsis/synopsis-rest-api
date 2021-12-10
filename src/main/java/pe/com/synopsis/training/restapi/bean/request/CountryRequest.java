package pe.com.synopsis.training.restapi.bean.request;

import lombok.Data;
import ws.synopsis.guides.gs_producing_web_service.Currency;

import java.io.Serializable;

@Data
public class CountryRequest implements Serializable {
    private String name;
    private Integer population;
    private String capital;
    private Currency currency;
}
