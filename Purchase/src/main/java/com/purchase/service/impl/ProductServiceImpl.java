package com.purchase.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.purchase.entity.Product;
import com.purchase.dto.ProductDTO;
import com.purchase.repository.ProductRepository;
import com.purchase.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
    @Autowired
    private ProductRepository productRepository;
    
    @CacheEvict(value = "product", allEntries = true)
	@Transactional
	public boolean save(ProductDTO product) throws Exception{
		
		Optional<Product> opt_product = productRepository.findById(product.getId());
		if(opt_product.isPresent()) {
			return false;	
		}else {
			productRepository.save(Product.builder()
					.id(product.getId())
					.name(product.getName())
					.price(product.getPrice())
					.build());	
		}
		return true;

	}
	
	@Cacheable(value = "product", key="#product")
	public Optional<Product> get(ProductDTO product) throws Exception{	
		Optional<Product> opt_product = productRepository.findById(product.getId());
		return opt_product;
	}
	
	@CacheEvict(value = "product", allEntries = true)
	@Transactional
	public boolean update(ProductDTO product) throws Exception{	
		Optional<Product> opt_product = productRepository.findById(product.getId());
		
		if(opt_product.isPresent()) {
			Product sel_product = opt_product.get();
			sel_product.updateProduct(product.getName(), product.getPrice());

		}else {
			return false;
			
		}
		return true;

	}
	
	@CacheEvict(value = "product", allEntries = true)
	@Transactional
	public void remove(ProductDTO product) throws Exception{	
		productRepository.deleteById(product.getId());
	}
	
	@Cacheable(value = "product")
	public List<Product> list() throws Exception{	
		return productRepository.findAll();
	}

	
}
