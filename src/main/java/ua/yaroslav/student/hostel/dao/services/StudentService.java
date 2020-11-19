package ua.yaroslav.student.hostel.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Student;
import ua.yaroslav.student.hostel.dao.repositories.StudentRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> studentList(){
        return (List<Student>) studentRepository.findAll();
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
        return studentRepository.save(student);  // < -- question!
    }

    public List<Student> findByName(String name){
        return studentRepository.findByFirstName(name);
    }

    public List<Student> findByFirstNameAndAndFaculty(String name, String faculty){
        if(faculty == ""){
            return studentRepository.findByFirstName(name);
        } else if(name == "")
        {
            return studentRepository.findAllByFaculty(faculty);
        } else {
            return studentRepository.findByFirstNameAndAndFaculty(name, faculty);
        }
    }

    // <--------!!!!!!!!!!!!

    public List<Student> findAllByBirthdayBetween(Date birthdayOne, Date birthdayTwo){
        return studentRepository.findAllByBirthdayBetween(birthdayOne, birthdayTwo);
    }

    // <--------!!!!!!!!!!!!

    public List<Student> findBy(String name, String secondName,
                                int roomNumber, String faculty,
                                String birthday){
        return studentRepository.findByFirstNameOrSecondNameOrRoomNumberOrFacultyOrBirthday(name, secondName,
                roomNumber, faculty, birthday);
    }
    public  List<Student> findByOr(String name, String secondName){
        return studentRepository.findAllByFirstNameOrSecondName(name, secondName);
    }
//
//    public List<Student> findByFirstNameAndAndFaculty(Student student) {
//        return studentRepository.findByFirstNameAndAndFaculty(student);
//    }
}
