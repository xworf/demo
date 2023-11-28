package cl.prueba.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143270953481470783L;
    
    /** The number. */
    private String number;
    
    /** The citycode. */
    private String citycode;
    
    /** The contrycode. */
    private String contrycode;

}
