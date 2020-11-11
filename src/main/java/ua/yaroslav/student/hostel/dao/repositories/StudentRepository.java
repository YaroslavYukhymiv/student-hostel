package ua.yaroslav.student.hostel.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.yaroslav.student.hostel.dao.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
