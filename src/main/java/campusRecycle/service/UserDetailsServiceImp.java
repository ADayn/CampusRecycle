package campusRecycle.service;

import campusRecycle.dao.UserRepository;
import campusRecycle.model.User;
import campusRecycle.util.OptionalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails temp = OptionalUtils.or(getAdminDetails(s), getUserDetails(s))
                .orElseThrow(() -> new UsernameNotFoundException("Username \"" + s + "\" not found"));
        return temp;
    }

    private Optional<UserDetails> getAdminDetails(String s) {
        // TODO
        return Optional.empty();
    }

    private Optional<UserDetails> getUserDetails(String s) {
        return userRepository
                .findByUsername(s)
                .map(u -> org.springframework.security.core.userdetails.User
                        .withUsername(s)
                        // TODO: Add password encoder
                        .password("{noop}" + u.getPassword())
                        .roles("USER")
                        .build()
                );
    }
}