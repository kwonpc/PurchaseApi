package com.purchase.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class StatsDTO {

	private Long id;
		
	private Long sumPrice;
	
	private Long cnt;
			
	public StatsDTO(Long id, Long sumPrice, Long cnt) {
		this.id = id;
		this.sumPrice = sumPrice;
		this.cnt = cnt;
	}
}
