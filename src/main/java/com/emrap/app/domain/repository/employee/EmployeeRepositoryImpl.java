package com.emrap.app.domain.repository.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Async
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
    @Async
    public Employee callWinner() {

        var query = entityManager.createQuery("select top 1 e from Employee e order by e.lastPrizeWinDate desc",
                Employee.class);

        var result = query.getResultList();

        return result.get(0);
    }

    @Override
    public FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize) {

        var query = entityManager.createQuery(
                "select e from Employee e order by e.startDate desc offset :pageSize * :pageNumber ROWS fetch next :pageSize only",
                Employee.class);
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
    public Employee findById(Long id) {

        return entityManager.find(Employee.class, id);
    }

    @Override
    public boolean delete(Long id) {

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Employee.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }

        return true;
    }

    @Override
    public boolean save(Employee entity) {

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
    public boolean checkIfEmailExist(String Email) {

        var query = entityManager.createQuery("select e from Employee e where e.email = :email", Employee.class);
        query.setParameter("email", Email);

        var result = query.getResultList();

        return result.size() > 0;
    }

    @Override
    public boolean checkIfPhoneNumberExist(String PhoneNumber) {

        var query = entityManager.createQuery("select e from Employee e where e.phoneNumber = :phoneNumber",
                Employee.class);
        query.setParameter("phoneNumber", PhoneNumber);

        var result = query.getResultList();

        return result.size() > 0;
    }

}
