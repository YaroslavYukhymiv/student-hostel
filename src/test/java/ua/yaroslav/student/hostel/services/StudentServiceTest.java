package ua.yaroslav.student.hostel.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.yaroslav.student.hostel.entity.Student;
import ua.yaroslav.student.hostel.repositories.StudentRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void studentListTest() {

        List<Student> list = Collections.EMPTY_LIST;

        when(studentService.studentList()).thenReturn(list);
        Assert.assertEquals(list, studentService.studentList());
        verify(studentRepository).findAll();

    }

    @Test
    public void saveStudentTest() {
        Student student = new Student();
        studentService.saveStudent(student);
        verify(studentRepository).save(student);
    }

    @Test
    public void getStudentByIdTest() {
        Student student = new Student();
        when(studentService.getStudentById(4)).thenReturn(Optional.of(student));
        Assert.assertEquals(Optional.of(student), studentService.getStudentById(4));
        verify(studentRepository).findById(4);

    }

    @Test
    public void deleteStudentByIdTest() {
        studentService.deleteStudentById(14);
        verify(studentRepository).deleteById(14);
    }

    @Test
    public void updateStudentTest() {
        Student student = new Student();
        studentService.updateStudent(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void findByNameTest() {
        studentService.findByName("Taras");
        verify(studentRepository).findByFirstName(any(String.class));
    }

    @Test
    public void findByFirstNameAndAndFaculty() {
        studentService.findByFirstNameAndAndFaculty("Taras", "RRE");
        verify(studentRepository).findByFirstNameAndAndFaculty(any(String.class), anyString());
    }

    @Test
    public void findAllByBirthdayBetween() {
        Date dateOne = new Date();
        Date dateTwo = new Date();
        when(studentRepository.findAllByBirthdayBetween(dateOne, dateTwo)).thenReturn(Collections.EMPTY_LIST);
        studentService.findAllByBirthdayBetween(dateOne, dateTwo);
        verify(studentRepository, times(1)).findAllByBirthdayBetween(dateOne, dateTwo);
    }

    @Test
    public void findByTest() {
        studentService.findBy(anyString(),anyString(),anyInt(),anyString(),anyString());
        verify(studentRepository, times(1)).findByFirstNameOrSecondNameOrRoomNumberOrFacultyOrBirthday(anyString(),anyString(),anyInt(),anyString(),anyString());
    }

}