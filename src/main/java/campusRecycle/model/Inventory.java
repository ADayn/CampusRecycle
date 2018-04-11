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
        return new ItemList(itemRepository.getByState(state));
    }

    public ItemList getListByStateAndCategory(ItemState state, String category) {
        return new ItemList(itemRepository.getByStateAndCategory(state, category));
    }

}
