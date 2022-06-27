package com.emrap.app.domain.repository.department;

import java.math.BigDecimal;
import java.util.List;

import com.emrap.app.core.utilities.result.FilterResult;
import com.emrap.app.entities.Department;

public interface DepartmentRepository {

    Department findById(Long id);

    boolean delete(Long id);

    boolean save(Department entity);

    FilterResult<List<Department>> getAllWithPagination(int pageNumber, int pageSize);

    int updateOfficeLocation(long departmentId, BigDecimal latitude, BigDecimal longitude);
}
