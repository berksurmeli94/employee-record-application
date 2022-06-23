package com.emrap.app.business.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.domain.repository.employee.EmployeeRepository;
import com.emrap.app.domain.repository.employee.ExtendedEmployeeRepository;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.employee.employeeCreateDto;
import com.emrap.app.dtos.employee.employeeUpdateDto;
import com.emrap.app.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ExtendedEmployeeRepository extendedEmployeeRepository;

    @Override
    public FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto) {
        return extendedEmployeeRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize());
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee createEmployee(employeeCreateDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee updateEmployee(employeeUpdateDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee callWinner() {
        return extendedEmployeeRepository.callWinner();
    }

    @Override
    public FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto, Date startDate, BigDecimal minIncome) {
        return extendedEmployeeRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize(), startDate,
                minIncome);
    }

}
