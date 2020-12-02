package ua.yaroslav.student.hostel.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.dao.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
