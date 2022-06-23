package com.emrap.app.domain.repository.department;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class DepartmentRepositoryImpl implements ExtendedDepartmentRepository {

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
    public int updateOfficeLocation(long departmentId, Double latitude, Double longitude) {
        var query = entityManager.createQuery(
                "update Department d set d.latitude = :latitude, d.longitude = :longitude where d.id = :departmentId");
        query.setParameter("latitude", latitude);
        query.setParameter("longitude", longitude);
        query.setParameter("departmentId", departmentId);

        return query.executeUpdate();
    }
}
