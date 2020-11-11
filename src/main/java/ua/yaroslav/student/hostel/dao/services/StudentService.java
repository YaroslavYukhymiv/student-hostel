package ua.yaroslav.student.hostel.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Student;
import ua.yaroslav.student.hostel.dao.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> studentList(){
        return studentRepository.findAll();
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Optional<Student> getStudentById(int id){
        return studentRepository.findById(id);
    }
    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }
    public Student updateStudent(Student student){
        return studentRepository.saveAndFlush(student);  // < -- question!
    }
}
