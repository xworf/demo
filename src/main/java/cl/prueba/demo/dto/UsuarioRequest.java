package cl.prueba.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * The Class UsuarioRequest.
 */
@Data
public class UsuarioRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3442303322215411907L;


	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The phones. */
	private List<PhoneRequest> phones;
}
