package ua.yaroslav.student.hostel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.yaroslav.student.hostel.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String name);
    public String findByPassword(String password);
}
