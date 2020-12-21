package ua.yaroslav.student.hostel.dao.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Student;
import ua.yaroslav.student.hostel.dao.repositories.StudentRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> studentList(){
        logger.debug("Was faund all students");
        return (List<Student>) studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        logger.debug("Student was saved: " + student);
        return studentRepository.save(student);
    }
    public Optional<Student> getStudentById(int id){
        logger.debug("Student " + id + "was faund");
        return studentRepository.findById(id);
    }
    public void deleteStudentById(int id){
        logger.debug("Student " + id + "was deleted");
        studentRepository.deleteById(id);
    }
    public Student updateStudent(Student student){
        logger.debug("Student " + student + "was updated");
        return studentRepository.save(student);  // < -- question!
    }

    public List<Student> findByName(String name){
        logger.debug("Student " + name + "was found");
        return studentRepository.findByFirstName(name);
    }

    public List<Student> findByFirstNameAndAndFaculty(String name, String faculty){
        if(faculty == ""){
            return studentRepository.findByFirstName(name);
        } else if(name == "")
        {
            return studentRepository.findAllByFaculty(faculty);
        } else {
            logger.debug("Was found students by firstName and faculty");
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
