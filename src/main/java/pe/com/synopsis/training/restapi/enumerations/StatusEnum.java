package pe.com.synopsis.training.restapi.enumerations;

import lombok.Getter;
import pe.com.synopsis.training.restapi.bean.response.base.Status;

@Getter
public enum StatusEnum {
	OK("0000", "Proceso exitoso."),
    UNEXPECTED_ERROR("9000", "Error inesperado.");
	
	private final Status status;

    StatusEnum(String code, String message) {
        this.status = new Status(code, message);
    }
}
