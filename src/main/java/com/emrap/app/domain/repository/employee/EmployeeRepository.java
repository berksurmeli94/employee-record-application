package com.emrap.app.domain.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrap.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, ExtendedEmployeeRepository {

}
