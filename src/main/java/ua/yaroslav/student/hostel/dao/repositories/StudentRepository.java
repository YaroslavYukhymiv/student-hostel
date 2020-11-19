package ua.yaroslav.student.hostel.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.dao.entity.Student;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByFirstName(String name);
    List<Student> findAllByFaculty(String faculty);
    List<Student> findByFirstNameAndAndFaculty(String name, String faculty);
    List<Student> findByFirstNameOrSecondNameOrRoomNumberOrFacultyOrBirthday(String name, String secondName,
                                                                             int roomNumber, String faculty,
                                                                             String birthday);
    // <--------!!!!!!!!!!!!

    List<Student> findAllByBirthdayBetween(Date birthdayOne, Date birthdayTwo);

    // <--------!!!!!!!!!!!!

//    List<Student> findStudentsByFirstNameAndFaculty(Student student);



    List<Student> findAllByFirstNameOrSecondName(String name, String secondName);
}
