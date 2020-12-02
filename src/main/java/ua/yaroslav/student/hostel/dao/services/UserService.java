package ua.yaroslav.student.hostel.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Role;
import ua.yaroslav.student.hostel.dao.entity.User;
import ua.yaroslav.student.hostel.dao.repositories.RoleRepository;
import ua.yaroslav.student.hostel.dao.repositories.UserRepository;

import java.util.Collections;

@Service
public class UserService implements AuthenticationProvider {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public boolean saveUser(User user){

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1,"ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }


//    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
//        if (user.getUsername() == "" && bCryptPasswordEncoder.encode(user.getPassword()) == userRepository.){
//
//        }

        return user;
    }

//    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

//    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        User user = userRepository.findByUsername(s);

        Object o = usernamePasswordAuthenticationToken.getCredentials();

        return user;

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String name = authentication.getName();
        String password = authentication.getCredentials().toString();


        if(password.equals("pass")){
            return new UsernamePasswordAuthenticationToken(name, password, Collections.singleton(new Role(4,"ROLE_PASSWORD")));
        } else {
            throw new BadCredentialsException("External system authentication faile");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
