package cl.prueba.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3442303322215411907L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	/** The name. */
	public String name;
    
    /** The email. */
    public String email;
    
    /** The password. */
    public String password;
	/** fecha de creación del usuario. */
    @Temporal(TemporalType.DATE)
	private Date created;
	
	/** fecha de la última actualización de usuario. */
    @Temporal(TemporalType.DATE)
	private Date modified;
	
	/** Fecha del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación). */
    @Temporal(TemporalType.DATE)
	private Date lastLogin;
	
	/** Token de acceso de la API. */
	private String token;
	
	/** Indica si el usuario sigue habilitado dentro del sistema. */
	private Boolean isActive;
	
	/**
	 * Listado de Telefonos asociados.
	 */
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
	private List<Phone> phones;
}
