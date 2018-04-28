package campusRecycle.controller;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MainController(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/home")
    public String showRegistrationPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("emailUsed", false);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(Model model, User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("emailUsed", true);
            return "register";
        } else if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("usernameUsed", true);
            return "register";
        } else {
            userRepository.save(user);
            // TODO: Send email
            return "index";
        }
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }
    

}
