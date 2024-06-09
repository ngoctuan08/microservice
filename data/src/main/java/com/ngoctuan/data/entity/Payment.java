package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AuditEntity {

    @EmbeddedId
    private PaymentId id;

    @ManyToOne
    @MapsId("customer_number")
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number")
    private Customer customer;

    @Column(nullable = false)
    private Date paymentDate;

    @Column(nullable = false)
    private BigDecimal amount;
}
