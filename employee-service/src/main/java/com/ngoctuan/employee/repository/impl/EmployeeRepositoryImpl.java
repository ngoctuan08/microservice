package com.ngoctuan.employee.repository.impl;

import com.ngoctuan.data.entity.Employee;
import com.ngoctuan.employee.repository.EmployeeRepository;
import io.vertx.mysqlclient.MySQLBuilder;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.SqlClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Mono<Employee> getListEmployeeDoNotHaveReportTo() {
        StringBuilder sql = new StringBuilder("select * from employee where reports_to is null");

        PoolOptions poolOptions = new PoolOptions().setMaxSize(5);
        SqlClient sqlClient = MySQLBuilder.client().with(poolOptions).build();

        return null;
    }
}
