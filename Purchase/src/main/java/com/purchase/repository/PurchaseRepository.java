package com.purchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.purchase.dto.StatsDTO;
import com.purchase.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	@Query(value="select new com.purchase.dto.StatsDTO(userId as id, sum(price) as sumPrice, count(1) as cnt ) from Purchase group by userId")
	public List<StatsDTO> userstats();

	@Query(value="select new com.purchase.dto.StatsDTO(productId as id, sum(price) as sumPrice, count(1) as cnt ) from Purchase group by productId")
	public List<StatsDTO> productstats();
	
}
