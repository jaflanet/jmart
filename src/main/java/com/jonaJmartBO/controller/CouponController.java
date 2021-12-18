package com.jonaJmartBO.controller;

import com.jonaJmartBO.Algorithm;
import com.jonaJmartBO.Coupon;
import com.jonaJmartBO.Predicate;
import com.jonaJmartBO.Product;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;
/**
 * @author Jona
 * @version 18/12/21
 */

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
	public static @JsonAutowired(filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\account.json", value = Coupon.class)JsonTable<Coupon> couponTable;

	@GetMapping("/{id}/canApply")
    boolean canApply(int id, double price, double discount){
		for(Coupon coupona : couponTable){
            if(coupona.id == id){
                return coupona.canApply(price, discount);
            }
        }
        return false;
    };
    
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(int page, int pageSize){
    	 Predicate<Coupon> pred = coupona -> !coupona.isUsed();
         return Algorithm.paginate(couponTable, page, pageSize, pred);
    }
    
	@Override
	public JsonTable<Coupon> getJsonTable() {
		// TODO Auto-generated method stub
		return couponTable;
	}
	
	@GetMapping("/{id}/isUsed")
	  boolean isUsed(int id){
		Coupon coupona = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return coupona.isUsed();
	    }

}
