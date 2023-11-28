package cl.prueba.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>,PagingAndSortingRepository<Usuario, Integer> {

	public List<Usuario> findByEmail(String email);
}
