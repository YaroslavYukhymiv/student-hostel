package ua.yaroslav.student.hostel.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.yaroslav.student.hostel.dao.entity.Student;
import ua.yaroslav.student.hostel.dao.HostelDao;

import java.util.List;

@Controller
public class HostelController {

    @Autowired
    HostelDao dao;

    @RequestMapping("/form")
    public String showForm(Model m){
        m.addAttribute("command", new Student());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("hos") Student student){
        if(student.getBirthday().equals("")){
            student.setBirthday("null");
        }
        dao.save(student);
        return "redirect:view";
    }

    @RequestMapping("view")
    public String veiw(Model m){
        List<Student> list = dao.getStudents();
        m.addAttribute("list", list);
        return "view";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m){
        Student student = dao.getHostelById(id);
        m.addAttribute("command", student);
        return "edit";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("hos") Student student){
        dao.update(student);
        return "redirect:/view";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/view";
    }
}
