package com.purchase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "purchaseinfo")
public class Purchase {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "product_id")
	private Long productId;

	@Column (name="price")
	private Long price;

	@Builder
    public Purchase(Long  id, Long userId, Long productId, Long price) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
    }

}
