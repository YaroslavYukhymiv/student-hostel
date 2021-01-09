package ua.yaroslav.student.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.yaroslav.student.hostel.entity.User;
import ua.yaroslav.student.hostel.services.UserService;

@Controller
public class LoginLogoutController {

    @Autowired
    UserService userService;

    @RequestMapping("/registration")
    public String registration(Model m){
        m.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){

        userService.saveUser(userForm);

//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }

        return "redirect:students/students";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(Model m){
        return "login";
    }

    @RequestMapping("/403")
    public String error(Model model) {
        return "403";
    }
}
