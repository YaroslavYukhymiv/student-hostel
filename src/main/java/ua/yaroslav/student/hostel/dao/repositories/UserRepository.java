package ua.yaroslav.student.hostel.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.dao.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String name);
    public String findByPassword(String password);
}
