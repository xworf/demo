package cl.prueba.demo.services;

import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;

/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService {

	/**
	 * Guardar usuario.
	 *
	 * @param newUser the new user
	 * @return the usuario response
	 */
	UsuarioResponse guardarUsuario(UsuarioRequest newUser);
	
	/**
	 * Consultar usuario.
	 *
	 * @param email the email
	 * @return the usuario response
	 */
	UsuarioResponse consultarUsuario(String email);
}