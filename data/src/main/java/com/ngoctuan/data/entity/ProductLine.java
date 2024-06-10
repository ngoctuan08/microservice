package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "productline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine extends AuditEntity implements Serializable {

    @Id
    @Column(name = "product_line")
    private String productLine;

    @Column(name = "text_description")
    private String textDescription;

    @Column(name = "html_description")
    private String htmlDescription;

    private byte[] image;

    @OneToMany(mappedBy = "productLine")
    private List<Product> products = new ArrayList<>();

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
