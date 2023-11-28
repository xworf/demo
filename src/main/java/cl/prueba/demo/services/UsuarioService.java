package cl.prueba.demo.services;

import java.util.Date;
import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.prueba.demo.dto.UsuarioRequest;
import cl.prueba.demo.dto.UsuarioResponse;
import cl.prueba.demo.model.Phone;
import cl.prueba.demo.model.Usuario;
import cl.prueba.demo.repository.PhoneRepository;
import cl.prueba.demo.repository.UsuarioRepository;
import cl.prueba.demo.util.Utils;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
			
			resuResponse.setId(save.getId());
			resuResponse.setName(save.getName());
			resuResponse.setEmail(save.getEmail());
			resuResponse.setCreated(save.getCreated());
			resuResponse.setModified(save.getModified());
			resuResponse.setLastLogin(save.getLastLogin());
			resuResponse.setToken(save.getToken());
			resuResponse.setIsactive(save.getIsActive());
			
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Correo ya existe");
		}
		
		return resuResponse;
	}
}
