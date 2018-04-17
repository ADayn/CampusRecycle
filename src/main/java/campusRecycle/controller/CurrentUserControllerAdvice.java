//package campusRecycle.controller;
//
//import campusRecycle.model.User;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@ControllerAdvice
//public class CurrentUserControllerAdvice {
//    @ModelAttribute("currentUser")
//    public User getCurrentUser(Authentication authentication) {
//        return (authentication == null) ? null : ((UserDetails) authentication.getPrincipal());
//    }
//}