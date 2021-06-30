package com.purchase.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.purchase.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ResponseDTO {

	private String code;
	private String message;
	
	private Object product;
	
	private Object user_stats;
	private Object product_stats;
}
