package com.ngoctuan.data.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order extends AuditEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
            @AttributeOverride(name = "zip", column = @Column(name = "shipping_zip")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city"))})
    private Address shippingAddress = new Address();

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "billing_street")),
            @AttributeOverride(name = "zip", column = @Column(name = "billing_zip")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city"))})
    private Address billingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public Order() {
        super();
    }

    public double totalPrice() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

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
