package com.emrap.app.domain.repository.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeRepositoryImpl implements ExtendedEmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize, Date startDate,
            BigDecimal minIncome) {

        var query = entityManager.createQuery(
                "select e from Employee e where e.startDate >= :startDate and e.salary >= :minIncome order by e.startDate desc offset :pageSize * :pageNumber ROWS fetch next :pageSize only",
                Employee.class);
        query.setParameter("startDate", startDate);
        query.setParameter("minIncome", minIncome);
        query.setParameter("pageNumber", pageNumber);
        query.setParameter("pageSize", pageSize);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(Employee.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        var result = new FilterResult<List<Employee>>();
        result.setItems(query.getResultList());
        result.setTotalCount(count.intValue());
        result.setFilteredCount(count.intValue() / pageSize);
        result.setCurrentPage(pageNumber);

        return result;
    }

    @Override
    public Employee callWinner() {
        var query = entityManager.createQuery("select top 1 e from Employee e order by e.lastPrizeWinDate desc",
                Employee.class);

        var result = query.getResultList();

        return result.get(0);
    }

}
