package campusRecycle.service;

import campusRecycle.dao.AdminRepository;
import campusRecycle.dao.UserRepository;
import campusRecycle.model.Person;
import campusRecycle.util.OptionalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository userRepository;
    private AdminRepository adminRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return OptionalUtils.or(getAdminDetails(s), getUserDetails(s))
                .map(u -> {
                    u.setPassword("{noop}" + u.getPassword());
                    return u;
                })
                .orElseThrow(() -> new UsernameNotFoundException("Username \"" + s + "\" not found"));
    }
    


    private Optional<? extends Person> getAdminDetails(String s) {
        // TODO
    	return adminRepository.findByUsername(s);
    }

    private Optional<? extends Person> getUserDetails(String s) {
        return  userRepository.findByUsernameAndDeleted(s, false);
//                .map(u -> org.springframework.security.core.userdetails.User
//                        .withUsername(s)
//                        // TODO: Add password encoder
//                        .password("{noop}" + u.getPassword())
//                        .roles("USER")
//                        .build()
//                );
    }
}