package pe.com.synopsis.training.restapi.bean.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryResponse implements Serializable {
    private String nameWeb;
    private Integer populationWeb;
    private String capitalWeb;
    private String currencyWeb;
    private String uuid;
}
