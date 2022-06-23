package com.emrap.app.business.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.employee.employeeCreateDto;
import com.emrap.app.dtos.employee.employeeUpdateDto;
import com.emrap.app.entities.Employee;

public interface EmployeeService {

    @Async
    FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto);

    FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto, Date startDate, BigDecimal minIncome);

    @Async
    Employee getById(Long id);

    @Async
    Employee createEmployee(employeeCreateDto dto);

    @Async
    Employee updateEmployee(employeeUpdateDto dto);

    @Async
    void deleteEmployee(Long id);

    @Async
    Employee callWinner();
}
