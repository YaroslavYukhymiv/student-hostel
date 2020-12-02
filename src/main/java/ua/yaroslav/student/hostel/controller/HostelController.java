package ua.yaroslav.student.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.yaroslav.student.hostel.dao.entity.Hostel;
import ua.yaroslav.student.hostel.dao.services.HostelService;

import java.util.List;

@Controller
public class HostelController {

    @Autowired
    HostelService service;

    @RequestMapping("/hostels")
    public String showHostels(Model model){
        List<Hostel> hostelList = service.hostelList();
        model.addAttribute("hostels", hostelList);
        return "hostels/hostels";
    }

    @RequestMapping(value = "/save_hostel", method = RequestMethod.POST)
    public String save(@ModelAttribute Hostel hostel){
        service.saveHostel(hostel);
        return "redirect:hostels";
    }
    @RequestMapping("/new_hostel")
    public String newHostel(Model model){
        model.addAttribute("command", new Hostel());
        return "/hostel_form";
    }
}
