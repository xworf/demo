package cl.prueba.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.demo.dto.Error;
import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;
import cl.prueba.demo.model.Usuario;
import cl.prueba.demo.services.IUsuarioService;
import cl.prueba.demo.util.Utils;

@RestController
@RequestMapping(path = "/usuarioRest")
public class UsuarioEndPoint {
	
	@Autowired
	private IUsuarioService usuarioService;
	
@GetMapping(path = "consultarUsuario")
public ResponseEntity<Usuario> getUsuario() {
	Usuario result = new Usuario();
	result.setName("Willy");
	return ResponseEntity.ok(result);
}

@PostMapping(path = "guardarUsuario")
public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioRequest usuario) {
	UsuarioResponse	usuarioReturn = null;
	
	if (validarParametros (usuario) ) {
		if ( !Utils.validaEmail(usuario.getEmail()) ) {
			Error error = new Error();
			error.setMensaje("Formato de eMail incorrecto.");
			return ResponseEntity.ok(error);
		} else {
			
		}
	}
	
	
	try {
		usuarioReturn = usuarioService.guardarUsuario(usuario);
	} catch (Exception e) {
		Error error = new Error();
		error.setMensaje(e.getMessage());
		return ResponseEntity.ok(error);
	}
	
	return ResponseEntity.ok(usuarioReturn);
}

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
