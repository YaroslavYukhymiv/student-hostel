package ua.yaroslav.student.hostel.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ua.yaroslav.student.hostel.entity.Hostel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HostelCustomRepositoryTest {

    @Mock
    EntityManager entityManager;

    @InjectMocks
    HostelCustomRepository hostelCustomRepository;

    @Test
    public void hostelByName() {

//        NativeQueryImpl nativeQueryImp = Mockito.mock(NativeQueryImpl.class, RETURNS_DEEP_STUBS);
        CriteriaBuilder criteriaBuilderImp = mock(CriteriaBuilder.class);
        CriteriaQuery criteriaQueryImp = mock(CriteriaQuery.class);
        Root<Hostel> rootImpl = mock(Root.class);
//        AbstractPredicateImpl abstractPredicate = mock(AbstractPredicateImpl.class);
        TypedQuery<Hostel> nativeQueryImp = Mockito.mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilderImp);
        when(criteriaBuilderImp.createQuery(Hostel.class)).thenReturn(criteriaQueryImp);
        when(criteriaQueryImp.from(Hostel.class)).thenReturn(rootImpl);
//        when(criteriaBuilderImp.equal(rootImpl.get("name"), "Andriy")).thenReturn(abstractPredicate);
//        when(criteriaQueryImp.where(abstractPredicate)).thenReturn();
        when(entityManager.createQuery(criteriaQueryImp)).thenReturn(nativeQueryImp);
//        when(nativeQueryImp.getResultList()).thenReturn(Collections.emptyList());

        hostelCustomRepository.hostelByName("Andriy");

//        when(entityManager.createQuery(any(String.class), eq(Hostel.class)).thenReturn(nativeQuery);
//        when(nativeQuery.getResultList()).thenReturn(Collections.emptyList());

        verify(entityManager).createQuery(criteriaQueryImp);

    }
}