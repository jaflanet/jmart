package com.jonaJmartBO.controller;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jonaJmartBO.Account;
import com.jonaJmartBO.Algorithm;
import com.jonaJmartBO.Product;
import com.jonaJmartBO.ProductCategory;
import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>  {

	public static @JsonAutowired(filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\account.json", value = Product.class)JsonTable<Product>  productTable;
	
	 @PostMapping("/create")
	    Product register
	    (
	        @RequestParam int accountId,
	        @RequestParam String name,
	        @RequestParam int weight,
	        @RequestParam boolean conditionUsed,
	        @RequestParam double price,
	        @RequestParam double discount,
	        @RequestParam ProductCategory category,
	        @RequestParam byte shipmentPlans
	        
	    )
	    {
		 AccountController controlA = new AccountController();
	        JsonTable<Account> accountTable = controlA.getJsonTable();
	        
	        for(Account account : accountTable){
	            if(account.id == accountId && account.store != null){
	                return new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
	            }
	        }
	        return null;
	    }
	 
	@Override
	public JsonTable getJsonTable() {
		// TODO Auto-generated method stub
		return productTable;
	}
	
	@GetMapping("/{id}/store")
    List<Product> getProductByStore(
    		@RequestParam int id,
            @RequestParam int page,
            @RequestParam int pageSize) {
		
		return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
	}
	
	@GetMapping("/getProductFilter")
	@ResponseBody
    List<Product> getProductFilter(
    		@RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam int accountId,
            @RequestParam String search,
            @RequestParam int minPrice,
            @RequestParam int maxPrice,
            @RequestParam ProductCategory category ) {
		
		List<Product> productList = null;
        for (Product list : productTable) {
            if (list.accountId == accountId)
                if (list.name.contains(search))
                    if (minPrice <= list.price)
                        if (maxPrice >= list.price)
                            if (list.category == category)
                                productList.add(list);
        }
        return productList;
    }
	
	
}
