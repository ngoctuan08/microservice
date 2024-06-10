package com.ngoctuan.employee.service;

import com.ngoctuan.data.entity.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> getListEmployeeDoNotHaveReportTo();
}
