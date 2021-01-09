package ua.yaroslav.student.hostel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.yaroslav.student.hostel.entity.Hostel;

@Repository
public interface HostelRepository extends CrudRepository<Hostel, Long> {

    Hostel findByName(String name);


}
