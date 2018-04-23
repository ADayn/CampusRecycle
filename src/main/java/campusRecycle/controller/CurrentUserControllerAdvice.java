package campusRecycle.controller;

import campusRecycle.dao.UserRepository;
import campusRecycle.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@ControllerAdvice
public class CurrentUserControllerAdvice {
    @Autowired
    UserRepository userRepository;

    @ModelAttribute("currentUsername")
    public String getCurrentUsername(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(auth -> ((UserDetails) authentication.getPrincipal()).getUsername())
                .orElse("Anonymous User");
    }

    @ModelAttribute("currentUserid")
    public Long getCurrentUserid(Authentication authentication) {
        return Optional.ofNullable(authentication)
                .map(auth -> (UserDetails) authentication.getPrincipal())
                .flatMap(details -> userRepository.findByUsername(details.getUsername()))
                .map(Person::getId)
                .orElse(null);
    }
}