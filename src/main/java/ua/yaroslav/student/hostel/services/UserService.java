package ua.yaroslav.student.hostel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.WebSecurityConfig;
import ua.yaroslav.student.hostel.entity.Role;
import ua.yaroslav.student.hostel.entity.User;
import ua.yaroslav.student.hostel.repositories.RoleRepository;
import ua.yaroslav.student.hostel.repositories.*;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService{

    Logger logger =  LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }

    public boolean saveUser(User user){

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1,"ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        logger.debug("User " + user + " was saved");
        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(userName);

        if (user == null) {
            logger.error("User: " + user + "was not found");
            throw new UsernameNotFoundException("User not found");
        }
//        if (user.getUsername() == "" && bCryptPasswordEncoder.encode(user.getPassword()) == userRepository.){
//
//        }
        logger.debug("User was authorizeted: " + user);
        return user;
    }
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//
//    }

//    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        User user = userRepository.findByUsername(s);

        Object o = usernamePasswordAuthenticationToken.getCredentials();

        return user;

    }

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//
//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        //bCryptPasswordEncoder.encode(password).equals(userRepository.findByPassword(password))
//
//        if(bCryptPasswordEncoder.matches(bCryptPasswordEncoder.encode(password), password)){
//            return new UsernamePasswordAuthenticationToken(name, password, Collections.singleton(new Role(4,"ROLE_PASSWORD")));
//        } else {
//            throw new BadCredentialsException("External system authentication faile");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
}
