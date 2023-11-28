package cl.prueba.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.prueba.demo.model.Phone;

/**
 * The Interface PhoneRepository.
 */
public interface PhoneRepository extends CrudRepository<Phone, Integer>,PagingAndSortingRepository<Phone, Integer> {

}
