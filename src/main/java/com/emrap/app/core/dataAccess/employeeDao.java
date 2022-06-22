package com.emrap.app.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrap.app.entities.Employee;

public interface employeeDao extends JpaRepository<Employee, Long> {

}
