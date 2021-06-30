package com.purchase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "productinfo")
public class Product {

	@Id
	@Column (name="id")
	private Long id;
	
	@Column (name="name")
	private String name;
	
	@Column (name="price")
	private Long price;
	
    @Builder
    public Product(Long  id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
	public void updateProduct(String name, Long price) {
		this.name = name;
		this.price = price;
	}
	
}
