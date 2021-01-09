package ua.yaroslav.student.hostel.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.yaroslav.student.hostel.entity.User;
import ua.yaroslav.student.hostel.repositories.UserRepository;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    public void saveUserForExistingUserTest() {

//        UserRepository userRepository = Mockito.mock(UserRepository.class);

        User userOne = new User();
        userOne.setUsername("Oleg");

//        UserService userService = new UserService(null, userRepository, null);

        User userTwo = new User();
        when(userRepository.findByUsername("Oleg")).thenReturn(userTwo);

        Assert.assertFalse(userService.saveUser(userOne));
    }

    @Test
    public void saveUserForNotExistingUserTest() {

        User userOne = new User();
        userOne.setUsername("Oleg");

        when(userRepository.findByUsername("Oleg")).thenReturn(null);

        Assert.assertTrue(userService.saveUser(userOne));
    }

    @Test
    public void loadUserByUsernameTest(){

        User userOne = new User();
        userOne.setUsername("Andriy");

        when(userRepository.findByUsername("Andriy")).thenReturn(userOne);

        Assert.assertEquals(userOne, userService.loadUserByUsername("Andriy"));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameForNotExistingUserTest(){

        User userOne = new User();
        userOne.setUsername("Andriy");

        when(userRepository.findByUsername("Andriy")).thenReturn(null);

        Assert.assertEquals(userOne, userService.loadUserByUsername("Andriy"));
    }
}