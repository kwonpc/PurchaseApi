package com.purchase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purchase.dto.RequestDTO;
import com.purchase.entity.Product;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class PurchaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
    @Test
    @Order(1)
    public void product1() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	map2.put("id", "5000702");
    	map2.put("name", "종량제200회듣기");
    	map2.put("price", "5100");
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### product test 1 ############");
    	mockMvc.perform(post("/product").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### product test 1 ############");
    }
    
    @Test
    @Order(2)
    public void product2() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	map2.put("id", "5000702");
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### product test 2 ############");
    	mockMvc.perform(get("/product").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### product test 2 ############");
    }
    
    @Test
    @Order(3)
    public void product3() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	map2.put("id", "5000702");
    	map2.put("name", "종량제500회듣기");
    	map2.put("price", "7100");
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### product test 3 ############");
    	mockMvc.perform(put("/product").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### product test 3 ############");
    }
    
    @Test
    @Order(4)
    public void product4() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	map2.put("id", "5000702");
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### product test 4 ############");
    	mockMvc.perform(delete("/product").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### product test 4 ############");
    }
    
    @Test
    @Order(5)
    public void product5() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### product test 5 ############");
    	mockMvc.perform(get("/productlist").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### product test 5 ############");
    }
    
    @Test
    @Order(6)
    public void purchase1() throws Exception {
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	map2.put("id", "7100107");
    	map2.put("userId", "1100007");
    	map2.put("productId", "5000302");
    	map2.put("price", "8900");
    	
    	map.put("purchase", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### purchase test 1 ############");
    	mockMvc.perform(post("/purchase").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### purchase test 1 ############");
    }
    
    @Test
    @Order(7)
    public void stat1() throws Exception {
    	
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### stat test 1 ############");
    	mockMvc.perform(get("/userstats").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### stat test 1 ############");
    }
    
    @Test
    @Order(8)
    public void stat2() throws Exception {
    	
    	Map map = new HashMap();
    	
    	Map map2 = new HashMap();
    	
    	map.put("product", map2);
    	
    	String content = objectMapper.writeValueAsString(map);
    	
    	System.out.println("########### stat test 1 ############");
    	mockMvc.perform(get("/productstats").content(content).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### stat test 1 ############");
    }
    
    
}
