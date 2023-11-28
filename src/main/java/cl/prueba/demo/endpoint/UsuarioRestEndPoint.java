package cl.prueba.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.demo.dto.Error;
import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;
import cl.prueba.demo.services.IUsuarioService;
import cl.prueba.demo.util.Utils;

/**
 * EndPoint de la clase Usuario.
 */
@RestController
@RequestMapping(path = "/usuarioRest")
public class UsuarioRestEndPoint {
	
	@Autowired
	private IUsuarioService usuarioService;
	@Value(value = "${app.regex}")
	private String regex;
	
/**
 * Consultar usuario.
 *
 * @param email the email
 * @return the response entity
 */
@GetMapping(path = "consultarUsuario")
public ResponseEntity<?> consultarUsuario(@RequestParam(name = "email") String email) {
	if ( !Utils.validaEmail(email) ) {
		Error error = new Error();
		error.setMensaje("Formato de eMail incorrecto.");
		return ResponseEntity.ok(error);
	}
	UsuarioResponse consultarUsuario = null;
	try {
		consultarUsuario = usuarioService.consultarUsuario(email);
	} catch (Exception e) {
		Error error = new Error();
		error.setMensaje(e.getMessage());
		return ResponseEntity.ok(error);
	}
	return ResponseEntity.ok(consultarUsuario);
}

/**
 * Guardar usuario.
 *
 * @param usuario the usuario
 * @return the response entity
 */
@PostMapping(path = "guardarUsuario")
public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioRequest usuario) {
	UsuarioResponse	usuarioReturn = null;
	
	if (validarParametros (usuario) ) {
		if ( !Utils.validaEmail(usuario.getEmail()) ) {
			Error error = new Error();
			error.setMensaje("Formato de eMail incorrecto.");
			return ResponseEntity.ok(error);
		} 
		if (!Utils.validarPassword(regex, usuario.getPassword())) {
			Error error = new Error();
			error.setMensaje("Formato de Password Incorrecto.");
			return ResponseEntity.ok(error);
		}
	}else {
		Error error = new Error();
		error.setMensaje("Parametros incorrectos.");
		return ResponseEntity.ok(error);
	}
	
	
	try {
		  usuarioService.guardarUsuario(usuario);
		 usuarioReturn = usuarioService.consultarUsuario(usuario.getEmail());
	} catch (Exception e) {
		Error error = new Error();
		error.setMensaje(e.getMessage());
		return ResponseEntity.ok(error);
	}
	
	return ResponseEntity.ok(usuarioReturn);
}

/**
 * Validar parametros.
 *
 * @param usuario the usuario
 * @return true, if successful
 */
private boolean validarParametros(UsuarioRequest usuario) {
	boolean result = Boolean.FALSE;
	if (usuario != null && usuario.getEmail() != null && !"".equalsIgnoreCase(usuario.getEmail().trim())) {
		result = Boolean.TRUE;
	} else {
		result = Boolean.FALSE;
	}
	return result;
}

}
