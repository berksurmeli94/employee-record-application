package com.emrap.app.domain.repository.department;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Department;

public interface ExtendedDepartmentRepository {

    @Async
    FilterResult<List<Department>> getAllWithPagination(int pageNumber, int pageSize);

    @Async
    int updateOfficeLocation(long departmentId, BigDecimal latitude, BigDecimal longitude);
}
