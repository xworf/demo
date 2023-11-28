package cl.prueba.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.demo.model.Usuario;

/**
 * The Interface UsuarioRepository.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>,PagingAndSortingRepository<Usuario, Integer> {

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<Usuario> findByEmail(String email);
}
