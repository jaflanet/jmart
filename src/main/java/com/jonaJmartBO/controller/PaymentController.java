package com.jonaJmartBO.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.jonaJmartBO.Account;
import com.jonaJmartBO.ObjectPoolThread;
import com.jonaJmartBO.Payment;
import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;

public class PaymentController implements BasicGetController<Payment> {
    
    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERIY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;
    public static @JsonAutowired(filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\randomPaymentList.json", value = Account.class)JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>(PaymentController::timekeeper);
    
    @PostMapping("/{id}/accept")
    public boolean accept(int id){
        return false;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(int id){
        return false;
    }
    @PostMapping("/create")
    public Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan){
		return null;
    }
    
    @Override
    public JsonTable<Payment> getJsonTable() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @PostMapping("/{id}/submit")
    public boolean submit(int id, String receipt) {
		return false;
        
    }
    
    private static boolean timekeeper(Payment payment) {
		return false;
    }

}
