package com.emrap.app.domain.repository.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Employee;

public interface ExtendedEmployeeRepository {
    FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize, Date startDate,
            BigDecimal minIncome);

    Employee callWinner();
}
