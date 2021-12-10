package pe.com.synopsis.training.restapi.bean.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CountryResponse implements Serializable {
    private String nameWeb;
    private Integer populationWeb;
    private String capitalWeb;
    private String currencyWeb;
    private String uuid;
}
