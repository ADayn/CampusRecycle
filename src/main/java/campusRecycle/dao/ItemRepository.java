package campusRecycle.dao;

import campusRecycle.model.Item;
import campusRecycle.model.ItemState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> getByState(ItemState state);

    List<Item> getByStateAndCategory(ItemState state, String category);
}