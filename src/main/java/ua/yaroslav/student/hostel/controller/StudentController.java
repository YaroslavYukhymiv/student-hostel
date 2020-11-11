package ua.yaroslav.student.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.yaroslav.student.hostel.dao.entity.Student;
import ua.yaroslav.student.hostel.dao.HostelDao;
import ua.yaroslav.student.hostel.dao.services.HostelService;
import ua.yaroslav.student.hostel.dao.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    HostelDao dao;

//    @Autowired
//    HostelService hostelService;

    @Autowired
    StudentService studentService;

    @RequestMapping("/form")
    public String showForm(Model m){
        m.addAttribute("command", new Student());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Student student){
        if(student.getBirthday().equals("")){
            student.setBirthday(null);
        }
        studentService.saveStudent(student);
        return "redirect:students";
    }

    @RequestMapping("/students")
    public String veiw(Model m){
        List<Student> list = studentService.studentList();
        m.addAttribute("list", list);
        return "students";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") int id,Model m){
        Optional<Student> student = studentService.getStudentById(id);
        m.addAttribute("command", student);    // < -- question!
        return "edit";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute Student student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
