package pe.com.synopsis.training.restapi.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pe.com.synopsis.training.restapi.bean.response.ErrorResponse;

@ControllerAdvice
public class CountryAdvice {

    @ExceptionHandler(CountryException.class)
    public ResponseEntity<?> countryException(CountryException e) {
        return ResponseEntity.internalServerError().body(ErrorResponse.builder().code("ERROR-0001").message("Pais no encontrado").build());
    }

}
