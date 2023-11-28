package cl.prueba.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Phone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143270953481470783L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
    /** The number. */
    public String number;
    
    /** The citycode. */
    public String citycode;
    
    /** The contrycode. */
    public String contrycode;
    
    /** The usuario. */
    @ManyToOne
    public Usuario usuario;

}
