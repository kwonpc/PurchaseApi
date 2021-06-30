package com.purchase.service;

import java.util.List;
import java.util.Optional;

import com.purchase.dto.ProductDTO;
import com.purchase.entity.Product;

public interface ProductService {

	public boolean save(ProductDTO product) throws Exception;
	
	public Optional<Product> get(ProductDTO product) throws Exception;
	
	public boolean update(ProductDTO product) throws Exception;
	
	public void remove(ProductDTO product) throws Exception;
	
	public List<Product> list() throws Exception;
}
