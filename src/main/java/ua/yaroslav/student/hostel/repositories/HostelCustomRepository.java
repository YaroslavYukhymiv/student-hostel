package ua.yaroslav.student.hostel.repositories;

import org.springframework.stereotype.Repository;
import ua.yaroslav.student.hostel.entity.Hostel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HostelCustomRepository {

    EntityManager entityManager;

    public List<Hostel> hostelByName(String name) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hostel> cq = cb.createQuery(Hostel.class);

        Root<Hostel> root = cq.from(Hostel.class);
        Predicate hostelByName = cb.equal(root.get("name"), name);
        cq.where(hostelByName);

        TypedQuery<Hostel> query = entityManager.createQuery(cq);
        return query.getResultList();

    }
}
