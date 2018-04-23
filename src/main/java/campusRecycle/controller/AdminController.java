package campusRecycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.Item;
import campusRecycle.model.ItemList;
import campusRecycle.model.ItemState;
import campusRecycle.service.Inventory;

@Controller
@RequestMapping("admin")
public class AdminController {
	
    private UserRepository userRepository;
    private Inventory inventory;
    private CategoryRepository categoryRepository;

    @Autowired
    public AdminController(UserRepository userRepository, Inventory inventory, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.inventory = inventory;
        this.categoryRepository = categoryRepository;
    }
    
  
    
	 @GetMapping("/allpendings")
	    public String showPendingList(Model model) {
	    	ItemList itemList=inventory.findListByState(ItemState.PENDING);
	    	model.addAttribute(itemList);
	    	return "pendings";
	    }
	    
	    @PostMapping("/allpendings")
	    public String processPending(
	    		@RequestParam("item_id") long item_id,
	    		@RequestParam("option") String option,
	    		@ModelAttribute("item") Item item) {
	    	System.out.println(item_id);
	    	System.out.println(option); 
	    	Item itemx=inventory.findItemById(item_id);
	    	if(option.equals("approve")) {
	    		System.out.println("itemx set state");
	    		itemx.setState(ItemState.ACTIVE);
	    	}else
	    		itemx.setState(ItemState.DENIED);
	    	System.out.println("to post itemx");
	    	System.out.println(itemx.getState());
	    	inventory.postItem(itemx);
	    	
	    	System.out.println("after post itemx");
	    	return "redirect:/items/allpendings";
	    }
}
