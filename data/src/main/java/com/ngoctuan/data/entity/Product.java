package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditEntity {

    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLine productLine;

    @Column(nullable = false)
    private String productScale;

    @Column(nullable = false)
    private String productVendor;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private short quantityInStock;

    @Column(nullable = false)
    private BigDecimal buyPrice;

    @Column(nullable = false)
    private BigDecimal msrp;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
