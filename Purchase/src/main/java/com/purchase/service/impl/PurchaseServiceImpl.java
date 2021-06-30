package com.purchase.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purchase.dto.PurchaseDTO;
import com.purchase.dto.StatsDTO;
import com.purchase.entity.Purchase;
import com.purchase.repository.PurchaseRepository;
import com.purchase.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
    @Autowired
    private PurchaseRepository purchaseRepository;
    
	@Transactional
	public boolean save(PurchaseDTO purchase) throws Exception{
		
		Optional<Purchase> opt_purchase = purchaseRepository.findById(purchase.getId());
		if(opt_purchase.isPresent()) {
			return false;

		}else {
			purchaseRepository.save(Purchase.builder()
					.id(purchase.getId())
					.userId(purchase.getUserId())
					.productId(purchase.getProductId())
					.price(purchase.getPrice())
					.build());			
		}
		return true;

	}
	
	@Cacheable(value = "userstats")
	public List<StatsDTO> userstats() throws Exception{
		return purchaseRepository.userstats();
	}
	
	@Cacheable(value = "productstats")
	public List<StatsDTO> productstats() throws Exception{
		return purchaseRepository.userstats();
	}
}

