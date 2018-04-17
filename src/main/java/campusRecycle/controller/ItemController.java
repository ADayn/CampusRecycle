package campusRecycle.controller;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.ItemRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.Inventory;
import campusRecycle.model.ItemState;
import campusRecycle.model.User;
import campusRecycle.responses.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("items")
public class ItemController {
    private UserRepository userRepository;
    private Inventory inventory;

    public ItemController(UserRepository userRepository, Inventory inventory) {
        this.userRepository = userRepository;
        this.inventory = inventory;
    }

    @GetMapping("/mine")
    public String showUsersItems(Model model, Principal p) {
        String username = p.getName();
        User u = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("activeItems", inventory.getListBySellerAndState(u, ItemState.ACTIVE));
        model.addAttribute("soldItems", inventory.getListBySellerAndState(u, ItemState.SOLD));
        model.addAttribute("pendingItems", inventory.getListBySellerAndState(u, ItemState.PENDING));
        return "mySales";
    }

    @GetMapping("/post")
    public String postItem(Model model) {
        return "postItem";
    }
}
