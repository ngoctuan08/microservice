package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AuditEntity implements Serializable {

    @Id
    @Column(name = "customer_number")
    @MapKey(name = "customer_number")
    private int customerNumber;

    @Column(nullable = false, name = "customer_name")
    private String customerName;

    @Column(nullable = false, name = "contact_last_name")
    private String contactLastName;

    @Column(nullable = false, name = "contact_first_name")
    private String contactFirstName;

    @Column(nullable = false, name = "phone")
    private String phone;

    @Column(nullable = false, name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Embedded
    private Address address;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @ManyToOne
    @JoinColumn(name = "sales_rep_employee_number")
    private Employee employee;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Shipment> shipments = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments = new ArrayList<>();

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
