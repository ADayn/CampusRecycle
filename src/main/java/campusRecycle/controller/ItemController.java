package campusRecycle.controller;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.*;
import campusRecycle.service.Inventory;
import campusRecycle.responses.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("items")
public class ItemController {
    private UserRepository userRepository;
    private Inventory inventory;
    private CategoryRepository categoryRepository;

    @Autowired
    public ItemController(UserRepository userRepository, Inventory inventory, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.inventory = inventory;
        this.categoryRepository = categoryRepository;
    }


    @ModelAttribute("categories")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/posted")
    public String showUsersItems(Model model, Principal p) {
        String username = p.getName();
        User u = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
        model.addAttribute("activeItems", inventory.findListBySellerAndState(u, ItemState.ACTIVE));
        model.addAttribute("soldItems", inventory.findListBySellerAndState(u, ItemState.SOLD));
        model.addAttribute("pendingItems", inventory.findListBySellerAndState(u, ItemState.PENDING));
        return "mySales";
    }

    @GetMapping("/post")
    public String showPostItem(Model model, Item item) {
        model.addAttribute("item", item);
        return "postItem";
    }

    @PostMapping("/post")
    public String postItem(@Valid Item item, BindingResult bindingResult, Authentication authentication) {
        User seller = Optional.ofNullable(authentication)
                .map(auth -> (UserDetails) authentication.getPrincipal())
                .flatMap(details -> userRepository.findByUsername(details.getUsername()))
                .orElse(null);
        if (bindingResult.hasErrors()) {
            return "postItem";
        } else {
            item.setSeller(seller);
            item.setDatePosted(new Date());
            inventory.postItem(item);
            return "redirect:/items/post/success";
        }
    }

    @GetMapping("/post/success")
    public String showSuccess() {
        return "postSuccess";
    }
}
