package campusRecycle.dao;

import org.springframework.data.repository.CrudRepository;
import campusRecycle.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
}
