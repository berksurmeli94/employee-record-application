package com.emrap.app.domain.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrap.app.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>, ExtendedDepartmentRepository {

}
