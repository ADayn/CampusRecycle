package campusRecycle.model;

import campusRecycle.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Inventory {

    private final ItemRepository itemRepository;

    @Autowired
    public Inventory(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemList getListByState(ItemState state) {
        return new ItemList(itemRepository.getAllByState(state));
    }

    public ItemList getListByStateAndCategory(ItemState state, Category category) {
        return new ItemList(itemRepository.getAllByStateAndCategory(state, category));
    }

    public ItemList getListBySellerAndState(User seller, ItemState state) {
        return new ItemList(itemRepository.getAllBySellerAndState(seller, state));
    }

}
