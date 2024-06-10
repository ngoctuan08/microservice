package com.ngoctuan.employee.repository;

import com.ngoctuan.data.entity.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {

    Mono<Employee> getListEmployeeDoNotHaveReportTo();
}
