package com.emrap.app.domain.repository.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.entities.Employee;

public interface EmployeeRepository {

    Employee findById(Long id);

    boolean delete(Long id);

    boolean save(Employee entity);

    FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize, Date startDate,
            BigDecimal minIncome);

    FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize);

    Employee callWinner();

    boolean checkIfEmailExist(String Email);

    boolean checkIfPhoneNumberExist(String PhoneNumber);
}
