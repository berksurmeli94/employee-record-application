package com.emrap.app.business.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrap.app.core.utilities.exceptions.NotFoundException;
import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.domain.repository.department.DepartmentRepository;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.department.departmentCreateDto;
import com.emrap.app.dtos.department.departmentUpdateDto;
import com.emrap.app.dtos.department.updateLocationDto;
import com.emrap.app.entities.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
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
    public Department updateDepartment(departmentUpdateDto dto) {

        var department = departmentRepository.findById(dto.getId());

        if (department == null)
            throw new NotFoundException("Department not found");

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
        department.setLatitude(dto.getLatitude());
        department.setLongitude(dto.getLongitude());

        departmentRepository.save(department);

        return department;
    }

    @Override
    public FilterResult<List<Department>> getAllDepartments(FilterRequestDto dto) {
        return departmentRepository.getAllWithPagination(dto.getPageNumber(), dto.getPageSize());
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    public Department updateOfficeLocation(updateLocationDto dto) {
        int record = departmentRepository.updateOfficeLocation(dto.getDepartmentId(), dto.getLatitude(),
                dto.getLongitude());

        if (record == 0)
            throw new NotFoundException("Department not found");

        return departmentRepository.findById(dto.getDepartmentId());
    }
}
