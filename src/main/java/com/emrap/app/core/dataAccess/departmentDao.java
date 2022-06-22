package com.emrap.app.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrap.app.entities.Department;

public interface departmentDao extends JpaRepository<Department, Long> {

}
