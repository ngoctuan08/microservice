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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends AuditEntity implements Serializable {

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

    @Column(nullable = false, name = "quantity_ordered")
    private int quantityOrdered;

    @Column(nullable = false, name = "price_each")
    private BigDecimal priceEach;

    @Column(nullable = false, name = "order_line_number")
    private short orderLineNumber;

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
