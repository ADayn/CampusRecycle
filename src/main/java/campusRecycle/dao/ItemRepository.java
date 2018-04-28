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
    List<Item> findAllByState(ItemState state);

    List<Item> findAllByStateAndCategory(ItemState state, Category category);

    List<Item> findAllBySellerAndState(User seller, ItemState state);

    List<Item> findAllByBuyer(User buyer);
    
    List<Item> findAllBySeller(User seller);
    
}