package com.emrap.app.business.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrap.app.core.utilities.exceptions.NotFoundException;
import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.domain.repository.department.DepartmentRepository;
import com.emrap.app.domain.repository.employee.EmployeeRepository;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.employee.employeeCreateDto;
import com.emrap.app.dtos.employee.employeeUpdateDto;
import com.emrap.app.entities.Employee;

import jakarta.validation.ValidationException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto) {
        return employeeRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize());
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee createEmployee(employeeCreateDto dto) {
        var department = departmentRepository.findById(dto.getDepartmentId());

        if (department == null)
            throw new NotFoundException("Department not found");

        boolean emailExists = employeeRepository.checkIfEmailExist(dto.getEmail());

        if (emailExists)
            throw new ValidationException("Employee with this email already exists");

        boolean phoneNumberExists = employeeRepository.checkIfPhoneNumberExist(dto.getPhoneNumber());

        if (phoneNumberExists)
            throw new ValidationException("Employee with this phone number already exists");

        var employee = new Employee();
        employee.setDepartmentId(dto.getDepartmentId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setEmail(dto.getEmail());
        employee.setStartDate(dto.getStartDate());
        employee.setSalary(dto.getSalary());

        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public Employee updateEmployee(employeeUpdateDto dto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee callWinner() {
        return employeeRepository.callWinner();
    }

    @Override
    public FilterResult<List<Employee>> getAllEmployees(FilterRequestDto dto, Date startDate, BigDecimal minIncome) {
        return employeeRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize(), startDate,
                minIncome);
    }

}
