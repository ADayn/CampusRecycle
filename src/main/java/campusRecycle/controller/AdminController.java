package campusRecycle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.Category;
import campusRecycle.model.Item;
import campusRecycle.model.ItemList;
import campusRecycle.model.ItemState;
import campusRecycle.model.User;
import campusRecycle.service.Inventory;
import java.util.*;  

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

	@GetMapping("/categories")
	public String showCategoryList(Model model) {
		Iterable<Category> cats=categoryRepository.findAll();

		//System.out.println(cats.iterator().next().getName());
		model.addAttribute("catList", cats.iterator());
		Category new_cat=new Category();
		model.addAttribute("new_cat", new_cat);
		return "editCategories";
	}

	//not used, because we don't want categories to be deleted
	@DeleteMapping("/categories")
	public String deleteCategory(@RequestParam("cat_id") long cat_id) {
		if(categoryRepository.findById(cat_id).isPresent()) {
			categoryRepository.delete(categoryRepository.findById(cat_id).get());
		}
		return "redirect:/admin/categories";
	}

	@PostMapping("/categories")
	public String addCategory(@ModelAttribute("new_cat") Category new_cat) {
		//System.out.println(new_cat.getName()+" "+String.valueOf(new_cat.getId()));
		categoryRepository.save(new_cat);
		return "redirect:/admin/categories";
	}

	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> users=userRepository.findAllByDeleted(false);
		model.addAttribute("userList", users.iterator());
		return "editUsers";
	}

	@PostMapping("/users")
	public String processUser(@RequestParam("user_id") long user_id,
			@RequestParam("option") String option) {
		if(option.equals("delete")) {
			if(userRepository.findById(user_id).isPresent()){
				//deny all active/pending items 
				User s=userRepository.findById(user_id).get();
				ItemList itemList=inventory.findListBySellerAndState(s, ItemState.PENDING);
				for(Item item: itemList) {
					item.setState(ItemState.DENIED);
				}
				itemList=inventory.findListBySellerAndState(s, ItemState.ACTIVE);
				for(Item item: itemList) {
					item.setState(ItemState.DENIED);
				}
				//mark the use deleted
				s.setDeleted(true);
				userRepository.save(s);
			}
		}
		return "redirect:/admin/users";
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
			@RequestParam("option") String option) {
		//System.out.println(item_id);
		//System.out.println(option); 
		Item itemx=inventory.findById(item_id).get();
		if(option.equals("approve")) {
			System.out.println("itemx set state");
			itemx.setState(ItemState.ACTIVE);
		}else
			itemx.setState(ItemState.DENIED);
		//System.out.println("to post itemx");
		//System.out.println(itemx.getState());
		inventory.postItem(itemx);

		//System.out.println("after post itemx");
		return "redirect:/admin/allpendings";
	}
}
