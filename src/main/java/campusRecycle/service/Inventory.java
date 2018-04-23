package campusRecycle.service;

import campusRecycle.dao.ItemRepository;
import campusRecycle.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Inventory {

    private final ItemRepository itemRepository;

    @Autowired
    public Inventory(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemList findListByState(ItemState state) {
        return new ItemList(itemRepository.findAllByState(state));
    }

    public ItemList findListByStateAndCategory(ItemState state, Category category) {
        return new ItemList(itemRepository.findAllByStateAndCategory(state, category));
    }

    public ItemList findListBySellerAndState(User seller, ItemState state) {
        return new ItemList(itemRepository.findAllBySellerAndState(seller, state));
    }

    public void postItem(Item item) {
        // TODO: Change to pending once admin is implemented
        //item.setState(ItemState.ACTIVE);
    	//item.setState(ItemState.PENDING);
        itemRepository.save(item);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void update(Item item) {
        itemRepository.save(item);
    }

}
