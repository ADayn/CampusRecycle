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



}
