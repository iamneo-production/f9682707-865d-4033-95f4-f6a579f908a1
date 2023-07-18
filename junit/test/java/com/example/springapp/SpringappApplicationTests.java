package com.example.springapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springapp.model.Inventory;
import com.example.springapp.model.Product;
import com.example.springapp.model.PurchaseOrder;
import com.example.springapp.model.Sales;
import com.example.springapp.model.Shipment;
import com.example.springapp.service.InventoryService;
import com.example.springapp.service.ProductService;
import com.example.springapp.service.PurchaseOrderService;
import com.example.springapp.service.SalesService;
import com.example.springapp.service.ShipmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	    @Autowired
	    private MockMvc mockMvc;

	    private static final Date date=new Date(2023-05-20);
	    	    
	    @Mock
	    private ProductService productService;
	    
	    @Mock
	    private InventoryService inventoryService;
	    
	    @Mock
	    private ShipmentService shipmentService;
	    
	    @Mock
	    private SalesService salesService;
	    
	    @Mock
	    private PurchaseOrderService prService;
	    
	    
	    Product p1=new Product(1L,"Soap","Skin whitening Soap",50,10L,"Chennai","abcd");
	    Product p2=new Product(2L,"Shampoo","Hair shampoo",80,10L,"Chennai","abcdef");

	    List<Product> productList = Arrays.asList(p1,p2);
	    
	    private String asJsonString(Object object) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();                                   
	        return objectMapper.writeValueAsString(object);
	    }
	    
	    @Test
	    public void testCreateProduct() throws Exception {

	        mockMvc.perform(MockMvcRequestBuilders.post("/product")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(p1)))
	                .andExpect(MockMvcResultMatchers.status().isCreated());

	    }
	    
	    @Test
	    public void testGetProductAll() throws Exception {
	    	
	        Mockito.when(productService.getAllProduct()).thenReturn(productList);

	        // Act
	        mockMvc.perform(get("/product"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    @Test
	    public void testGetProductById() throws Exception {
	    	Long Id=1L;
	    	
	        Mockito.when(productService.getProductById(Id)).thenReturn(p1);

	        // Act
	        mockMvc.perform(get("/product").param("id", "1"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }

	    Inventory in1=new Inventory(1L,p1,10L,"Chennai",date);
	    Inventory in2=new Inventory(2L,p1,10L,"Chennai",date);
	    
	    List<Inventory> inventoryList =Arrays.asList(in1,in2);
	    
	    
	    @Test
	    public void testCreateInventory() throws Exception {

	        mockMvc.perform(MockMvcRequestBuilders.post("/inventory")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(in1)))
	                .andExpect(MockMvcResultMatchers.status().isCreated());

	    }
	    
	    @Test
	    public void testGetInventoryAll() throws Exception {
	    	
	        Mockito.when(inventoryService.getAllInventory()).thenReturn(inventoryList);

	        // Act
	        mockMvc.perform(get("/inventory"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    @Test
	    public void testGetInventoryById() throws Exception {
	    	Long Id=1L;
	    	
	        Mockito.when(inventoryService.getInventoryById(Id)).thenReturn(in1);

	        // Act
	        mockMvc.perform(get("/inventory").param("id", "1"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    Shipment s1=new Shipment(1L,1L,10L,"Trichy",date);
	    Shipment s2=new Shipment(2L,1L,5L,"Chennai",date);
	    
	    List<Shipment> shipmentList =Arrays.asList(s1,s2);

	    @Test
	    public void testGetShipmentAll() throws Exception {
	    	
	        Mockito.when(shipmentService.getAllShipment()).thenReturn(shipmentList);

	        // Act
	        mockMvc.perform(get("/shipment"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    
	    Sales s11=new Sales(1L,1L,10L,50D,date);
	    Sales s22=new Sales(2L,1L,5L,50D,date);
	    
	    List<Sales> salesList =Arrays.asList(s11,s22);

	    
	    @Test
	    public void testGetSalesById() throws Exception {
	    	Long Id=1L;
	    	
	        Mockito.when(salesService.getSalesByProductId(Id)).thenReturn(salesList);

	        // Act
	        mockMvc.perform(get("/shipment").param("productId", "1"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    PurchaseOrder pr1=new PurchaseOrder(1L,1L,10L,"ABC",date);
	    PurchaseOrder pr2=new PurchaseOrder(2L,1L,5L,"QWER",date);
	    
	    List<PurchaseOrder> prList =Arrays.asList(pr1,pr2);

	    @Test
	    public void testGetPurchaseAll() throws Exception {
	    	
	        Mockito.when(prService.getAllPurchaseOrder()).thenReturn(prList);

	        // Act
	        mockMvc.perform(get("/purchase-order"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
	    
	    @Test
	    public void testGetPurchaseById() throws Exception {
	    	Long Id=1L;
	    	
	        Mockito.when(prService.getPurchaseOrderByProductId(Id)).thenReturn(prList);

	        // Act
	        mockMvc.perform(get("/purchase-order").param("productId", "1"))
	        .andExpect(MockMvcResultMatchers.status().isOk())
	        .andDo(print())
            .andExpect(content().contentType("application/json"))
   			.andExpect(jsonPath("$").isArray())
   			.andReturn();
	    }
}
