package com.emrap.app.domain.repository.employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.emrap.app.core.utilities.results.FilterResult;
import com.emrap.app.entities.Employee;

public interface ExtendedEmployeeRepository {

    @Async
    FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize, Date startDate,
            BigDecimal minIncome);

    @Async
    FilterResult<List<Employee>> getAllWithPagination(int pageNumber, int pageSize);

    @Async
    Employee callWinner();
}
