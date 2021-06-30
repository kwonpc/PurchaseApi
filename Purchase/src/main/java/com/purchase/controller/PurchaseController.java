package com.purchase.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.dto.ProductDTO;
import com.purchase.dto.PurchaseDTO;
import com.purchase.dto.RequestDTO;
import com.purchase.dto.ResponseDTO;
import com.purchase.dto.ResponseDTO.ResponseDTOBuilder;
import com.purchase.dto.StatsDTO;
import com.purchase.dto.UserDTO;
import com.purchase.entity.Product;
import com.purchase.entity.User;
import com.purchase.service.ProductService;
import com.purchase.service.PurchaseService;
import com.purchase.service.UserService;

@RestController
public class PurchaseController {
	
    @Autowired
    private ProductService productService;
    
    @Autowired
    private PurchaseService purchaseService;
	
    @Autowired
    private UserService userService;
    
	@PostMapping(value="/purchase", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> post (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(requestDTO.getPurchase().getProductId());
			Optional<Product> product = productService.get(productDTO);
			if(!product.isPresent()) {
				responseDTOBuilder.code("001");
				responseDTOBuilder.message("상품없음");
				return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
			}	

			UserDTO userDTO = new UserDTO();
			userDTO.setId(requestDTO.getPurchase().getUserId());
			Optional<User> user = userService.get(userDTO);
			if(!user.isPresent()) {
				responseDTOBuilder.code("005");
				responseDTOBuilder.message("사용자없음");
				return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
			}	

			boolean saveYn = purchaseService.save(requestDTO.getPurchase());
			if(saveYn) {
				responseDTOBuilder.code("000");
				responseDTOBuilder.message("성공");	
			}else {
				responseDTOBuilder.code("006");
				responseDTOBuilder.message("주문이 이미 존재");
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
	
	@GetMapping(value="/userstats", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> userstats (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			
			List<StatsDTO> list = purchaseService.userstats();
			responseDTOBuilder.user_stats(list);
			responseDTOBuilder.code("000");
			responseDTOBuilder.message("성공");				
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
	
	@GetMapping(value="/productstats", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> productstats (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			
			List<StatsDTO> list = purchaseService.productstats();
			responseDTOBuilder.product_stats(list);
			responseDTOBuilder.code("000");
			responseDTOBuilder.message("성공");		
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}

}
