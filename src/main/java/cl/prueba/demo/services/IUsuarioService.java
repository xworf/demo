package cl.prueba.demo.services;

import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;

public interface IUsuarioService {

	UsuarioResponse guardarUsuario(UsuarioRequest newUser);

}