package com.emrap.app.business.department;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.department.departmentCreateDto;
import com.emrap.app.dtos.department.departmentUpdateDto;
import com.emrap.app.dtos.department.updateLocationDto;
import com.emrap.app.entities.Department;

public interface DepartmentService {

    @Async
    FilterResult<List<Department>> getAllDepartments(FilterRequestDto dto);

    @Async
    Department getById(Long id);

    @Async
    Department createDepartment(departmentCreateDto dto);

    @Async
    Department updateDepartment(departmentUpdateDto dto);

    @Async
    Department updateOfficeLocation(updateLocationDto dto);

    @Async
    void deleteDepartment(Long id);
}
