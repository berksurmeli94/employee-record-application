package com.emrap.app.business.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.employee.employeeCreateDto;
import com.emrap.app.dtos.employee.employeeUpdateDto;
import com.emrap.app.entities.Employee;

public interface EmployeeService {

    FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto);

    FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto, Date startDate, BigDecimal minIncome);

    Employee getById(Long id);

    Employee createEmployee(employeeCreateDto dto) throws MethodArgumentNotValidException;

    Employee updateEmployee(employeeUpdateDto dto);

    void deleteEmployee(Long id);

    Employee callWinner();
}
