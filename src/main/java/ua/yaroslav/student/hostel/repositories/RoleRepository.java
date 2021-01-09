package ua.yaroslav.student.hostel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
