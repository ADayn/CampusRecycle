package campusRecycle.controller;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.*;
import campusRecycle.service.Inventory;
import campusRecycle.responses.ResourceNotFoundException;
import campusRecycle.util.Page;
import campusRecycle.util.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.lang.Math.max;

@Controller
@RequestMapping("/items")
public class ItemController {
    private UserRepository userRepository;
    private Inventory inventory;
    private CategoryRepository categoryRepository;

//    private List<Integer> calculatePages(Integer page, Integer maxPages)

    @Autowired
    public ItemController(UserRepository userRepository, Inventory inventory, CategoryRepository categoryRepository, HttpServletRequest request) {
        this.userRepository = userRepository;
        this.inventory = inventory;
        this.categoryRepository = categoryRepository;
//        this.request = request;
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
    public String postItem(@Valid Item item, BindingResult bindingResult, Authentication authentication, Model model) {
        User seller = Optional.ofNullable(authentication)
                .map(auth -> (UserDetails) authentication.getPrincipal())
                .flatMap(details -> userRepository.findByUsername(details.getUsername()))
                .orElse(null);
        if (bindingResult.hasErrors()) {
            return "postItem";
        } else {
        	System.out.println("In postItem "+item.getId());
            item.setSeller(seller);
            item.setDatePosted(new Date());
            item.setState(ItemState.PENDING);
            inventory.postItem(item);
            model.addAttribute("item", item);
            return "uploadImage";
        }
    }

    @PostMapping("/{itemId}/uploadImage")
    public String postItem(@PathVariable Long itemId, @RequestParam("file") MultipartFile file, Model model) {
        Item item = inventory.findById(itemId).get();
        try {
            item.setImage(file.getBytes());
            inventory.update(item);
            return "redirect:/items/post/success";
        } catch (IOException e) {
            // TODO: Log error
            e.printStackTrace();
            return "uploadImage";
        }
    }

    @GetMapping("/{itemId}/image")
    @ResponseBody public byte[] getImage(@PathVariable Long itemId, Model model) {
        return inventory
                .findById(itemId)
                .map(Item::getImage)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/post/success")
    public String showSuccess() {
        return "postSuccess";
    }
    
    @GetMapping("/detail") // detail?id=
    public String showItemDetail(@RequestParam(value="id") long id, Model model) {
    	Item item=inventory.findById(id).orElseThrow(ResourceNotFoundException::new);
    	model.addAttribute("item", item);
    	return "itemDetail";
    }
    
    @PostMapping("/modify") //update,mark as sold, or delete
    public String modifyItem(@RequestParam(value="item_id") long id, 
    		      @RequestParam(value="buyer_email") Optional<String> buyer_email,
    		      @RequestParam(value="option") String option, Model model) {
    	System.out.println(id);
    	System.out.println(buyer_email);
    	Item item=inventory.findById(id).orElseThrow(ResourceNotFoundException::new);
    	System.out.println(item.getDescription());
    	if (option.equals("update")) {
    		model.addAttribute(item);
    		System.out.println(item.getId());
    		return "postItem";
    	}else if(option.equals("delete")) {
    		inventory.delete(item);
    		return "redirect:/items/posted";
    	}else { // mark as sold
    		Optional<User> buyer=userRepository.findByEmail(buyer_email.get());
    		if(!buyer.isPresent()) {
    			return "buyerNotFound";
    		}
    		item.setState(ItemState.SOLD);
    		item.setBuyer(buyer.get());
    		inventory.update(item);
    		return "redirect:/items/posted";
    	}
    	
    }

    @GetMapping("/findByCategory")
    public String findByCategory(Model model,
                                 @RequestParam Long id,
                                 @RequestParam(required = false, defaultValue = "0") Integer pageNumber) {

        Category category = categoryRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        Pageable<Item> pageable = inventory
                .findListByStateAndCategory(ItemState.ACTIVE, category)
                .getPageable();
        Page<Item> page = pageable.getPage(pageNumber);

        model.addAttribute("noResults", pageable.isEmpty());
        model.addAttribute("currentPageNumber", pageNumber);
        model.addAttribute("category", category);
        model.addAttribute("items", page);
        model.addAttribute("pageLinks", createPageLinks(pageable, pageNumber));

        return "browseCategory";
    }

    private List<Integer> createPageLinks(Pageable<Item> pageable, int currentPageNumber) {
        int linksToShow = 10;
        int numPages = pageable.getNumPages();
        List<Integer> pageLinks = new ArrayList<>(linksToShow);
        int minLink = max(0, min(numPages - linksToShow, currentPageNumber - ((linksToShow + 1) / 2)));
        int maxLink = min(numPages, max(currentPageNumber + (linksToShow / 2), linksToShow));
        return IntStream
                .range(minLink, maxLink)
                .boxed()
                .collect(Collectors.toList());
    }
}
