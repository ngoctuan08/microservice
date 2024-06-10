package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

	@Column(nullable = false)
	private String city;

	private String state;

	@Column(nullable = false,name = "postal_code")
	private String postalCode;

	@Column(nullable = false)
	private String country;
}
