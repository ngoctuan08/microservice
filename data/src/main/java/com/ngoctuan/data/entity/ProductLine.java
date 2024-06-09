package com.ngoctuan.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine extends AuditEntity {

    @Id
    private String productLine;

    private String textDescription;

    private String htmlDescription;

    private byte[] image;

    @OneToMany(mappedBy = "productLine")
    private List<Product> products = new ArrayList<>();
}
