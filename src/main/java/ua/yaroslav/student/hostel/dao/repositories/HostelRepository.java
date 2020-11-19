package ua.yaroslav.student.hostel.dao.repositories;

import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.yaroslav.student.hostel.dao.entity.Hostel;

@Repository
public interface HostelRepository extends CrudRepository<Hostel, Long> {

    Hostel findByName(String name);


}
