package com.purchase.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.dto.RequestDTO;
import com.purchase.dto.ResponseDTO;
import com.purchase.dto.ResponseDTO.ResponseDTOBuilder;
import com.purchase.entity.Product;
import com.purchase.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

	@PostMapping(value="/product", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> post (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			
			boolean saveYn = productService.save(requestDTO.getProduct());
			
			if(saveYn) {
				responseDTOBuilder.code("000");
				responseDTOBuilder.message("성공");	
			}else {
				responseDTOBuilder.code("002");
				responseDTOBuilder.message("상품이 이미 존재");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
    
	@GetMapping(value="/product", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> get (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			Optional<Product> product = productService.get(requestDTO.getProduct());
			
			if(product.isPresent()) {
				responseDTOBuilder.product(product.get());
				responseDTOBuilder.code("000");
				responseDTOBuilder.message("성공");
				
			}else {
				responseDTOBuilder.code("001");
				responseDTOBuilder.message("상품없음");
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
	
	@PutMapping(value="/product", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> put (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			boolean updateYn = productService.update(requestDTO.getProduct());
			
			if(updateYn) {
				responseDTOBuilder.code("000");
				responseDTOBuilder.message("성공");	
			}else {
				responseDTOBuilder.code("003");
				responseDTOBuilder.message("상품이 미존재");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/product", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> delete (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			productService.remove(requestDTO.getProduct());
			
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
	
	@GetMapping(value="/productlist", produces="application/json; charset=UTF-8")
	public ResponseEntity<ResponseDTO> list (@RequestBody RequestDTO requestDTO ) throws IOException {
		
		ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();
		
		try {
			List<Product> productlist = productService.list();
			
			if(productlist.size()>0) {
				responseDTOBuilder.product(productlist);
				responseDTOBuilder.code("000");
				responseDTOBuilder.message("성공");				
			}else {
				responseDTOBuilder.code("004");
				responseDTOBuilder.message("목록없음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			responseDTOBuilder.code("999");
			responseDTOBuilder.message("실패");
			return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.BAD_REQUEST);	
		}
		
		return new ResponseEntity<ResponseDTO>(responseDTOBuilder.build(), HttpStatus.OK);
	}
}
