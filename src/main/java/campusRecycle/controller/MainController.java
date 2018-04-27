package campusRecycle.controller;

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

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String showRegistrationPage(Model model) {
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
