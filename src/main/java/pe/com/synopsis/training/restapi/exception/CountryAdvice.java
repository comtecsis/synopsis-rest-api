package pe.com.synopsis.training.restapi.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.com.synopsis.training.restapi.bean.response.ErrorResponse;

@ControllerAdvice
public class CountryAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CountryAdvice.class);

    @ExceptionHandler(CountryException.class)
    public ResponseEntity<?> countryException(CountryException e) {
        logger.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(ErrorResponse.builder().code("ERROR-0001").message("Pais no encontrado").build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(ErrorResponse.builder().code("ERROR-0000").message("Error inesperado.").build());
    }

}
