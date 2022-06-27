package com.emrap.app.business.department;

import java.util.List;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.department.departmentCreateDto;
import com.emrap.app.dtos.department.departmentUpdateDto;
import com.emrap.app.dtos.department.updateLocationDto;
import com.emrap.app.entities.Department;

public interface DepartmentService {

    FilterResult<List<Department>> getAllDepartments(FilterRequestDto dto);

    Department getById(Long id);

    Department createDepartment(departmentCreateDto dto);

    Department updateDepartment(departmentUpdateDto dto);

    Department updateOfficeLocation(updateLocationDto dto);

    void deleteDepartment(Long id);
}
