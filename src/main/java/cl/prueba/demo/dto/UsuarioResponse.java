package cl.prueba.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new usuario response.
 */
@Data
public class UsuarioResponse implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3442303322215411907L;

	/** id del usuario. */
	private Integer id;
	/** The name. */
	private String name;
    
    /** The email. */
	private String email;
    
    /** The password. */
	private String password;
	
	/** fecha de creación del usuario. */
	private String created;
	
	/** fecha de la última actualización de usuario. */
	private String modified;
	
	/** Fecha del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación). */
	private String lastLogin;
	
	/** Token de acceso de la API. */
	private String token;
	
	/** Indica si el usuario sigue habilitado dentro del sistema. */
	private Boolean isactive;
	
	/** The phones. */
	private List<PhoneResponse> phones;
   
}
