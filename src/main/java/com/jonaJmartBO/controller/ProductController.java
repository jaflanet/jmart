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
import com.jonaJmartBO.Payment;
import com.jonaJmartBO.Predicate;
import com.jonaJmartBO.Product;
import com.jonaJmartBO.ProductCategory;
import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;

/**
 * @author Jona
 * @version 18/12/21
 */

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>  {

	public static @JsonAutowired(value= Product.class, filepath="C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\randomProductList.json") JsonTable<Product> productTable;

	//mendapatkan procut yang ada di toko
  	/**
  	 * @param id
  	 * @param page
  	 * @param pageSize
  	 * @return
  	 */
  	@GetMapping("/{id}/page")
      @ResponseBody List<Product> getProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
  		List<Product> productList = new ArrayList<>();
          Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
          if(accountTarget != null){
              for(Product product : ProductController.productTable){
                  for(Payment payment : PaymentController.paymentTable){
                      if(payment.productId == product.id && product.accountId == accountTarget.id){
                          productList.add(product);
                      }
                  }
              }
          }
          return Algorithm.paginate(productList, page, pageSize, e->true);
      }
  	
  	//get product yang sudah di beli
      /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/purchases/page")
      @ResponseBody List<Product> getMyProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
          List<Product> productList = new ArrayList<>();
          List<Payment> paymentList = Algorithm.<Payment>paginate(PaymentController.paymentTable, page, pageSize, p -> p.buyerId == id);
          for(Product product : getJsonTable()){
              for(Payment payment : paymentList){
                  if(payment.productId == product.id){
                      productList.add(product);
                  }
              }
          }
          return Algorithm.<Product>paginate(productList, page, pageSize, e -> true);
      }
      
      
  		//menambahkan produk pada toko
      /**
     * @param accountId
     * @param name
     * @param weight
     * @param conditionUsed
     * @param price
     * @param discount
     * @param category
     * @param shipmentPlans
     * @return
     */
    @PostMapping("/create")
      Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans){
          for(Account account : AccountController.accountTable){
              if(account.id == accountId && account.store != null){
                  Product newProduct = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                  productTable.add(newProduct);
                  return newProduct;
              }
          }
          return null;
      }
      public JsonTable<Product> getJsonTable() {
          return productTable;
      }
      
      
      /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/store")
      List<Product> getProductByStore(@RequestParam int id, @RequestParam int page, @RequestParam int pageSize){
          return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, p -> (p.accountId == id));
      }
      
      //melakukan filter search
      /**
     * @param page
     * @param pageSize
     * @param search
     * @param minPrice
     * @param maxPrice
     * @param category
     * @return
     */
    @GetMapping("/getFiltered")
      List<Product> getProductFiltered(@RequestParam(defaultValue="0")  int page, @RequestParam(defaultValue="5")  int pageSize,
                                       @RequestParam  String search,
                                       @RequestParam  int minPrice, @RequestParam  int maxPrice,
                                       @RequestParam  ProductCategory category)
      {
          Predicate<Product> pred = p -> ((p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
          return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
      }
    
}
