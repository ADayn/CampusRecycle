package campusRecycle.dao;

import campusRecycle.model.Category;
import campusRecycle.model.Item;
import campusRecycle.model.ItemState;
import campusRecycle.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> getAllByState(ItemState state);

    List<Item> getAllByStateAndCategory(ItemState state, Category category);

    List<Item> getAllBySellerAndState(User seller, ItemState state);

    List<Item> getAllByBuyer(User seller);
}