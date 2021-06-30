package com.purchase.service;

import java.util.List;

import com.purchase.dto.PurchaseDTO;
import com.purchase.dto.StatsDTO;

public interface PurchaseService {

	public boolean save(PurchaseDTO purchase) throws Exception;
	
	public List<StatsDTO> userstats() throws Exception;
	
	public List<StatsDTO> productstats() throws Exception;
}
