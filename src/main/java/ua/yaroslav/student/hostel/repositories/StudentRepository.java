package ua.yaroslav.student.hostel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.entity.Student;


import java.util.Date;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByFirstName(String name);
    List<Student> findAllByFaculty(String faculty);
    List<Student> findAllByFirstNameOrSecondName(String name, String secondName);
    List<Student> findByFirstNameAndAndFaculty(String name, String faculty);

    List<Student> findByFirstNameOrSecondNameOrRoomNumberOrFacultyOrBirthday(String name, String secondName,
                                                                             int roomNumber, String faculty,
                                                                             String birthday);

    List<Student> findAllByBirthdayBetween(Date birthdayOne, Date birthdayTwo);
    List<Student> findByRoomNumber(int room);



}
