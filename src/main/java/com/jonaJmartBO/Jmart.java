package com.jonaJmartBO;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jmart{
	
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
	public static void main(String[] args){
		try {
			SpringApplication.run(Jmart.class, args);
//            String filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\json\\randomPaymentList.json";
//            JsonTable<Payment> table = new JsonTable<>(Payment.class, filepath);
//            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
//            paymentPool.start();
//            table.forEach(payment -> paymentPool.add(payment));
//            while(paymentPool.size() != 0);
//            paymentPool.exit();
//            while(paymentPool.isAlive());
//            System.out.println("Thread exited successfully");
//            Gson gson = new Gson();
//            table.forEach(payment -> {
//                String history = gson.toJson(payment.history);
//                System.out.println(history);
//            });
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
	public static boolean paymentTimekeeper(Payment payment) {
		 Payment.Record record = payment.history.get(payment.history.size() - 1);
	        long elapsed = System.currentTimeMillis() - record.date.getTime();
	        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
	            record.status = Invoice.Status.FAILED;
	            return true;
	        } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
	            record.status = Invoice.Status.FAILED;
	            return true;
	        } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
	            record.status = Invoice.Status.DELIVERED;
	            return true;
	        } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
	            record.status = Invoice.Status.FINISHED;
	            return true;
	        } else {
	            return false;
	        }
	}
	
}
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }
//    
//    public static void main(String[] args){
//        String filepath = "C:/Users/Jona/Desktop/KULIAH SEM 5/praktikum oop/modul 1/jmart/city.json";
//        Gson gson = new Gson();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states: ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    	System.out.println("account id:" + new Account(null, null, null, -1).id);
//    	System.out.println("account id:" + new Account(null, null, null, -1).id);
//    	System.out.println("account id:" + new Account(null, null, null, -1).id);
//
//    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//    	try{
//            List<Product> list = read("C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\randomProductList.json");
////            List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
////            filtered.forEach(product -> System.out.println(product.price));
////            List<Product> resultByName = filterByName(list, "gtx", 1, 5);
////            resultByName.forEach(product -> System.out.println(product.name));
//            List<Product> resultByAccountId = filterByAccountId(list, 1, 1, 2);
//            resultByAccountId.forEach(product -> System.out.println(product.name));
//
//        }catch (Throwable t)
//        {
//            t.printStackTrace();
//        }
//		try{
//			String filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\account.json" ;
//
//			JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
//			tableAccount.add(new Account("jonathan", "jonathanfaren@gogo.com", "1234567j"));
//			tableAccount.writeJson();
//
//			tableAccount = new JsonTable<>(Account.class, filepath);
//			tableAccount.forEach(account -> System.out.println(account.toString()));
//		}
//
//		catch (Throwable t)
//		{
//			t.printStackTrace();
//		}
//    }
    
//    public static List<Product> read (String filepath){
//    	List<Product> products = new ArrayList<>();
//        try{
//            Gson gson = new Gson();
//            JsonReader reader = new JsonReader(new FileReader(filepath));
//            reader.beginArray();
//            while(reader.hasNext()){
//                products.add(gson.fromJson(reader, Product.class));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return products;
//    }
//    
//    public static List<Product> filterByCategory (List<Product>list,ProductCategory category){
//    	List<Product> filtered = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).category == category) {
//                filtered.add(list.get(i));
//            }
//        }
//        return filtered;
//    }
//    
//    public static List<Product> filterByPrice (List<Product>list,double minPrice, double maxPrice){
//    	List<Product> products = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++){
//            if(minPrice <= 0.0){
//                if(list.get(i).price <= maxPrice){
//                    products.add(list.get(i));
//                }
//            }else if(maxPrice <= 0.0){
//                if(list.get(i).price >= minPrice){
//                    products.add(list.get(i));
//                }
//            }else{
//                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
//                    products.add(list.get(i));
//                }
//            }
//        }
//        return products;
//    }
//    
//    public static List<Product> filterByAccountId (List<Product>list,int accountId, 
//    		int page, int pageSize){
//        Predicate<Product> predicate = alist -> (alist.accountId == accountId);
//        return paginate(list, page, pageSize, predicate);
//
//    }
//    
//    public static List<Product> filterByName (List<Product>list, String search, 
//    	int page, int pageSize){
//    	Predicate<Product> predicate = alist -> (alist.name.toLowerCase().contains(search.toLowerCase()));
//        return paginate(list, page, pageSize, predicate);
//    }
//    
//    private static List<Product> paginate (List<Product>list, int page, 
//    	int pageSize,  Predicate<Product> pred){
//    	return list.stream().filter(alist -> pred.predicate(alist)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
//    }
