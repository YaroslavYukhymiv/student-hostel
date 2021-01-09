package ua.yaroslav.student.hostel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.yaroslav.student.hostel.WebSecurityConfig;
import ua.yaroslav.student.hostel.entity.Student;
import ua.yaroslav.student.hostel.controller.models.StudentBirthdayBetween;
import ua.yaroslav.student.hostel.services.StudentService;
import ua.yaroslav.student.hostel.services.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class StudentController {

    Logger logger =  LoggerFactory.getLogger(WebSecurityConfig.class);

//    @Autowired
//    HostelDao dao;

    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String search(Model model, Student student){
        List<Student> students = studentService.findByFirstNameAndAndFaculty(student.getFirstName(), student.getFaculty());
        model.addAttribute("listStudents", students);
        logger.trace("Controller /search was executed");
        return "students/studentsFind";
    }

    @RequestMapping("/search_all")
    public String search(@ModelAttribute("studentAll") Student student, Model model){
        List<Student> students = studentService.findBy(student.getFirstName(), student.getSecondName(),
                student.getRoomNumber(), student.getFaculty(), student.getBirthday()) ;
//        List<Student> students = studentService.findByOr(student.getFirstName(), student.getSecondName());
        model.addAttribute("listStudents", students);
        logger.trace("Controller /search_all was executed");
        return "students/studentsFind";
    }

    @RequestMapping(value = "/search_birthday", method = RequestMethod.POST)
    public String search(String birthdayOne, String birthdayTwo, Model model) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date from = simpleDateFormat.parse(birthdayOne);
        Date from2 = simpleDateFormat.parse(birthdayTwo);
        List<Student> students = studentService.findAllByBirthdayBetween(from, from2);
        model.addAttribute("listStudents", students);
        logger.trace("Controller /search_birthday was executed");
        return "students/studentsFind";
    }

    @RequestMapping("/form")
    public String showForm(Model m){
        m.addAttribute("command", new Student());
        logger.trace("Controller '/form' was executed");
        return "students/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Student student){
        if(student.getBirthday().equals("")){
            student.setBirthday(null);
        }
        studentService.saveStudent(student);
        logger.trace("Controller /save was executed");
        return "redirect:students/students";
    }

    @RequestMapping("/students")
    public String veiw(Model m){
        List<Student> list = studentService.studentList();
        m.addAttribute("list", list);
        m.addAttribute("command", new Student());
        m.addAttribute("studentAll", new Student());
        m.addAttribute("studentsBirthday", new StudentBirthdayBetween());
        logger.info("Controller /students was called");
        return "students/students";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") int id,Model m){
        Optional<Student> student = studentService.getStudentById(id);
        m.addAttribute("command", student);
        logger.trace("Controller /edit was executed");
        return "edit";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute Student student){
        studentService.updateStudent(student);
        logger.trace("Controller /editsave was executed");
        return "redirect:/students/students";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        studentService.deleteStudentById(id);
        logger.trace("Controller /selete/" + id + " was executed");
        return "redirect:/students/students";
    }
}
