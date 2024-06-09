package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends AuditEntity {

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("order_number")
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private Order order;

    @ManyToOne
    @MapsId("product_code")
    @JoinColumn(name = "product_code", referencedColumnName = "product_code")
    private Product product;

    @Column(nullable = false)
    private int quantityOrdered;

    @Column(nullable = false)
    private BigDecimal priceEach;

    @Column(nullable = false)
    private short orderLineNumber;
}
