package com.jonaJmartBO;
import java.util.Date;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Jonathan Aurelius)
 * @version (version number or date here)
 */
public abstract class Invoice extends Serializable
{
   
   public int buyerId;
   public int complaintId;
   public final Date date;
   public int productId;
   public Rating rating;
   
   public enum Rating {
        NONE,
        GOOD,
        BAD,
        NEUTRAL;       
    }

   public enum Status {
        CANCELLED,
        COMPLAINT,
        DELIVERED,
        FAILED,
        FINISHED,
        ON_DELIVERY,
        ON_PROGRESS,
        WAITING_CONFIRMATION; 
   }
    
   protected Invoice(int buyerId, int productId){
	   this.buyerId = buyerId;
       this.productId = productId;
       this.date = new Date();
       this.rating = Rating.NONE;
       this.complaintId = -1;
    }
    
   public abstract double getTotalPay(Product product);
}
