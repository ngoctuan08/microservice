package com.ngoctuan.employee.web;

import com.ngoctuan.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getListEmployeeDoNotHaveReportTo() {
        return ResponseEntity.ok(employeeService.getListEmployeeDoNotHaveReportTo());
    }
}
