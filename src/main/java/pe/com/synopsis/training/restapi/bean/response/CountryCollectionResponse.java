package pe.com.synopsis.training.restapi.bean.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
public class CountryCollectionResponse {
    List<CountryResponse> countries;
}
