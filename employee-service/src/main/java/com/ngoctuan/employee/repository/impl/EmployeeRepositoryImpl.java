package com.ngoctuan.employee.repository.impl;

import com.ngoctuan.data.entity.Employee;
import com.ngoctuan.employee.repository.EmployeeRepository;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.SqlClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private SqlClient client;

    @Override
    public Mono<Employee> getListEmployeeDoNotHaveReportTo() {

        String sql = "select * from employee where reports_to is null";

        return Mono.create(sink -> {
            client.preparedQuery(sql).execute().onComplete(result -> {
                if (result.succeeded()) {
                    RowSet<Row> rows = result.result();
                    if (rows.size() > 0) {
                        Row row = rows.iterator().next();
                        Employee employee = fromRow(row);
                        sink.success(employee);
                    } else {
                        sink.success(null);
                    }
                } else {
                    sink.error(result.cause());
                }
            });
        });
    }

    private Employee fromRow(Row row) {
        Employee employee = new Employee();
        employee.setEmployeeNumber(row.getInteger("employee_number"));
        employee.setEmail(row.getString("email"));
        employee.setLastName(row.getString("last_name"));
        employee.setFirstName(row.getString("first_name"));
        employee.setExtension(row.getString("extension"));
        employee.setJobTitle(row.getString("job_title"));
        return employee;
    }
}
