package cl.prueba.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private Integer id;
	
    /** The number. */
	private String number;
    
    /** The citycode. */
	private String citycode;
    
    /** The contrycode. */
	private String contrycode;
    
    /** The usuario. */
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

}
