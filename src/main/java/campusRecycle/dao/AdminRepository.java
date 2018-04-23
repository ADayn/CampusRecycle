package campusRecycle.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import campusRecycle.model.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {
	Optional<Admin> findByEmail(String email);
	Optional<Admin> findByUsername(String username);
}
