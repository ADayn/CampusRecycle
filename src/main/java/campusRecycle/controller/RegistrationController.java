package campusRecycle.controller;

import campusRecycle.dao.UserRepository;
import campusRecycle.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Setup referenced from https://www.codebyamir.com/blog/user-account-registration-with-spring-boot

@Controller
public class RegistrationController {
    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model, User user) {
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
//            model.addAttribute("user", user);
            return "index";
        }
    }
}
