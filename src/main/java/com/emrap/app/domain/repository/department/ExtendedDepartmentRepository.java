package com.emrap.app.domain.repository.department;

import java.util.List;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Department;

public interface ExtendedDepartmentRepository {

    FilterResult<List<Department>> getAllWithPagination(int pageNumber, int pageSize);

    int updateOfficeLocation(long departmentId, Double latitude, Double longitude);
}
