package cl.prueba.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.prueba.demo.dto.PhoneResponse;
import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;
import cl.prueba.demo.model.Phone;
import cl.prueba.demo.model.Usuario;
import cl.prueba.demo.repository.PhoneRepository;
import cl.prueba.demo.repository.UsuarioRepository;
import cl.prueba.demo.util.Utils;


/**
 * Clase de servicio del usuario.
 */
@Service
public class UsuarioService implements IUsuarioService {

	/** The usuario repository. */
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/** The phone repository. */
	@Autowired
	private PhoneRepository phoneRepository;
	

	
	@Override
	@Transactional
	public UsuarioResponse guardarUsuario(UsuarioRequest req){
		UsuarioResponse resuResponse = new UsuarioResponse();
		List<Usuario> findByEmail = usuarioRepository.findByEmail(req.getEmail());
		if (null != findByEmail && findByEmail.size()==0) {
			Usuario newUser = new Usuario();
			newUser.setEmail(req.getEmail());
			newUser.setName(req.getName());
			newUser.setPassword(req.getPassword());
			newUser.setCreated(new Date(System.currentTimeMillis()));
			newUser.setModified(new Date(System.currentTimeMillis()));
			newUser.setLastLogin(new Date(System.currentTimeMillis()));
			newUser.setToken(Utils.generarToken(8));
			newUser.setIsActive(Boolean.TRUE);
			Usuario save = usuarioRepository.save(newUser);
			req.getPhones().stream().forEach(fonoR -> {
				Phone fono = new Phone();
				fono.setCitycode(fonoR.getCitycode());
				fono.setContrycode(fonoR.getContrycode());
				fono.setNumber(fonoR.getNumber());
				fono.setUsuario(save);
				phoneRepository.save(fono);
			});
			Optional<Usuario> userFull = usuarioRepository.findById(save.getId());
			traspasarDatos(resuResponse, save, userFull.get()); 
			
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "El correo ya registrado");
		}
		
		return resuResponse;
	}

	/**
	 * Traspasar datos.
	 *
	 * @param resuResponse the resu response
	 * @param save the save
	 * @param userFull the user full
	 */
	private void traspasarDatos(UsuarioResponse resuResponse, Usuario save, Usuario userFull) {
		resuResponse.setId(save.getId());
		resuResponse.setName(save.getName());
		resuResponse.setEmail(save.getEmail());
		resuResponse.setPassword(save.getPassword());
		resuResponse.setCreated(Utils.formatoFecha(save.getCreated()));
		resuResponse.setModified(Utils.formatoFecha(save.getModified()));
		resuResponse.setLastLogin(Utils.formatoFecha(save.getLastLogin()));
		resuResponse.setToken(save.getToken());
		resuResponse.setIsactive(save.getIsActive());
		List<PhoneResponse> listaTelefonos = new ArrayList<>();
		if (userFull.getPhones() != null) {
			userFull.getPhones().forEach(fono ->{
			PhoneResponse newFono = new PhoneResponse();
			newFono.setCitycode(fono.getCitycode());
			newFono.setContrycode(fono.getContrycode());
			newFono.setNumber(fono.getNumber());
			listaTelefonos.add(newFono);
		});
		}
	
		resuResponse.setPhones(listaTelefonos);
	}

	@Override
	public UsuarioResponse consultarUsuario(String email) {
		UsuarioResponse result = new UsuarioResponse();
		List<Usuario> findByEmail = usuarioRepository.findByEmail(email);
		if (null != findByEmail && findByEmail.size()>0) {
			traspasarDatos(result, findByEmail.get(0), findByEmail.get(0));			
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Correo Asociado NO existe");
		}
		return result;
	}
}
