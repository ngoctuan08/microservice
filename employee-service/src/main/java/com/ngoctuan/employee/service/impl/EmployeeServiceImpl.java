package com.ngoctuan.employee.service.impl;

import com.ngoctuan.data.entity.Employee;
import com.ngoctuan.employee.repository.EmployeeRepository;
import com.ngoctuan.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Mono<Employee> getListEmployeeDoNotHaveReportTo() {
        return employeeRepository.getListEmployeeDoNotHaveReportTo();
    }
}
