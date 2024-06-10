package com.ngoctuan.data.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Order extends AuditEntity implements Serializable {

    @Id
    @Column(name = "order_number")
    @MapKey(name = "order_number")
    private int orderNumber;

    @Column(nullable = false, name = "order_date")
    private LocalDateTime orderDate;

    @Column(nullable = false, name = "required_date")
    private LocalDateTime requiredDate;

    @Column(name = "shipped_date")
    private LocalDateTime shippedDate;

    @Column(nullable = false)
    private String status;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails  = new ArrayList<>();

    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    @OneToOne(mappedBy = "order")
    private Shipment shipment;
//    @Embedded
//    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
//            @AttributeOverride(name = "zip", column = @Column(name = "shipping_zip")),
//            @AttributeOverride(name = "city", column = @Column(name = "shipping_city"))})
//    private Address shippingAddress = new Address();
//
//    @Embedded
//    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "billing_street")),
//            @AttributeOverride(name = "zip", column = @Column(name = "billing_zip")),
//            @AttributeOverride(name = "city", column = @Column(name = "billing_city"))})
//    private Address billingAddress = new Address();

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
