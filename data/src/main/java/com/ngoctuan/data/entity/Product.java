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
public class Product extends AuditEntity implements Serializable {

    @Id
    @Column(name = "product_code")
    private String productCode;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLine productLine;

    @Column(nullable = false, name = "product_scale")
    private String productScale;

    @Column(nullable = false, name = "product_vendor")
    private String productVendor;

    @Column(nullable = false, name = "product_description")
    private String productDescription;

    @Column(nullable = false, name = "quantity_in_stock")
    private short quantityInStock;

    @Column(nullable = false, name = "buy_price")
    private BigDecimal buyPrice;

    @Column(nullable = false)
    private BigDecimal msrp;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();

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
