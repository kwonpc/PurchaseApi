package com.purchase.dto;

import com.purchase.dto.ProductDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestDTO {

	private ProductDTO product;
	
	private PurchaseDTO purchase;
	
}
