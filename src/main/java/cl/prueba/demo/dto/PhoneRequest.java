package cl.prueba.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143270953481470783L;
    private String number;
    private String citycode;
    private String contrycode;

}
