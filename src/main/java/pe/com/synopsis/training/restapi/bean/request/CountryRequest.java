package pe.com.synopsis.training.restapi.bean.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryRequest implements Serializable {
    private String name;
}
