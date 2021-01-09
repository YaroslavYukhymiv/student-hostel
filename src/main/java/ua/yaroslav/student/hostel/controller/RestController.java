package ua.yaroslav.student.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.yaroslav.student.hostel.entity.Student;
import ua.yaroslav.student.hostel.repositories.StudentRepository;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/getstudents")
    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @RequestMapping("/getbyname/{name}")
    public List<Student> getStudent(@PathVariable String name){
        return studentRepository.findByFirstName(name);
    }

    @RequestMapping("/getbyroom")
    public List<Student> getByRoom(@RequestParam("room") int room){
        return studentRepository.findByRoomNumber(room);
    }

    @RequestMapping(value = "/savestudent", method = RequestMethod.POST)
    public ResponseEntity saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return new ResponseEntity("Student appended succesfuly",HttpStatus.OK);
    }

}
