package cl.prueba.demo.dto;

import java.io.Serializable;
import java.util.Date;

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
	public String name;
    
    /** The email. */
    public String email;
    
    /** The password. */
    public String password;
	
	/** fecha de creación del usuario. */
	private Date created;
	
	/** fecha de la última actualización de usuario. */
	private Date modified;
	
	/** Fecha del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación). */
	private Date lastLogin;
	
	/** Token de acceso de la API. */
	private String token;
	
	/** Indica si el usuario sigue habilitado dentro del sistema. */
	private Boolean isactive;
   
}
