package com.emrap.app.domain.repository.department;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.entities.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FilterResult<List<Department>> getAllWithPagination(int pageNumber, int pageSize) {

        var query = entityManager.createQuery(
                "select d from Department d order by d.startDate desc offset :pageSize * :pageNumber ROWS fetch next :pageSize only",
                Department.class);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(Department.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        var result = new FilterResult<List<Department>>();
        result.setItems(query.getResultList());
        result.setTotalCount(count.intValue());
        result.setFilteredCount(count.intValue() / pageSize);
        result.setCurrentPage(pageNumber);

        return result;
    }

    @Override
    public int updateOfficeLocation(long departmentId, BigDecimal latitude, BigDecimal longitude) {

        var query = entityManager.createQuery(
                "update Department d set d.latitude = :latitude, d.longitude = :longitude where d.id = :departmentId");
        query.setParameter("latitude", latitude);
        query.setParameter("longitude", longitude);
        query.setParameter("departmentId", departmentId);

        return query.executeUpdate();
    }

    @Override
    public Department findById(Long id) {

        return entityManager.find(Department.class, id);
    }

    @Override
    public boolean save(Department entity) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Long id) {

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Department.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }

        return true;
    }
}
