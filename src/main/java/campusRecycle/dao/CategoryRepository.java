package campusRecycle.dao;

import org.springframework.data.repository.CrudRepository;
import campusRecycle.model.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    @Override
    Optional<Category> findById(Long aLong);
}
