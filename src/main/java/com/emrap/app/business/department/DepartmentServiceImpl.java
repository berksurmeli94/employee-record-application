package com.emrap.app.business.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.domain.repository.department.DepartmentRepository;
import com.emrap.app.domain.repository.department.ExtendedDepartmentRepository;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.department.departmentCreateDto;
import com.emrap.app.dtos.department.departmentUpdateDto;
import com.emrap.app.dtos.department.updateLocationDto;
import com.emrap.app.entities.Department;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ExtendedDepartmentRepository extendedDepartmentRepository;

    @Override
    @Async
    public Department createDepartment(departmentCreateDto dto) {
        var department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setLatitude(dto.getLatitude());
        department.setLongitude(dto.getLongitude());

        departmentRepository.save(department);

        return department;
    }

    @Override
    @Async
    public Department updateDepartment(departmentUpdateDto dto) {

        var department = departmentRepository.findById(dto.getId()).get();

        if (department == null)
            throw new IllegalArgumentException("Department not found");

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setLatitude(dto.getLatitude());
        department.setLongitude(dto.getLongitude());

        departmentRepository.save(department);

        return department;
    }

    @Override
    @Async
    public FilterResult<List<Department>> getAllDepartments(FilterRequestDto dto) {
        return extendedDepartmentRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize());
    }

    @Override
    @Async
    public Department getById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    @Async
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateOfficeLocation(updateLocationDto dto) {
        int record = extendedDepartmentRepository.updateOfficeLocation(dto.getDepartmentId(), dto.getLatitude(),
                dto.getLongitude());

        if (record == 0)
            throw new IllegalArgumentException("Department not found");

        return departmentRepository.findById(dto.getDepartmentId()).get();
    }
}
