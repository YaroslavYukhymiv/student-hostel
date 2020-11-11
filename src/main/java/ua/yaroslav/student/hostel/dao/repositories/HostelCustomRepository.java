package ua.yaroslav.student.hostel.dao.repositories;

import ua.yaroslav.student.hostel.dao.entity.Hostel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class HostelCustomRepository {

    EntityManager m;

    public List<Hostel> hostelByName(String name) {

        CriteriaBuilder cb = m.getCriteriaBuilder();
        CriteriaQuery<Hostel> cq = cb.createQuery(Hostel.class);

        Root<Hostel> hostel = cq.from(Hostel.class);
        Predicate hostelByName = cb.equal(hostel.get("name"), name);
        cq.where(hostelByName);

        TypedQuery<Hostel> query = m.createQuery(cq);
        return query.getResultList();
    }


}
