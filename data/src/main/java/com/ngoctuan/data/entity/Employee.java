package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends AuditEntity implements Serializable {

    @Id
    @Column(name = "employee_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String email;

    @Column(name = "reports_to")
    private int reportsTo;

    @Column(nullable = false, name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "employee")
    private List<Customer> customers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "office_code")
    private Office office;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
