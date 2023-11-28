package cl.prueba.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UsuarioRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3442303322215411907L;


	private String name;
	private String email;
	private String password;
	private List<PhoneRequest> phones;
}
