package com.jonaJmartBO;
import java.util.Date;

import com.jonaJmartBO.dbjson.Serializable;

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
//	    public ArrayList<Record> history = new ArrayList<>();
	    public int productId;
	    public Rating rating;
	    public enum Status{
	        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
	        COMPLAINT, FINISHED, FAILED, DELIVERED
	    }
	    public enum Rating{
	        NONE, BAD, NEUTRAL, GOOD
	    }
	    class Record{
	        public Date date;
	        public String message;
	        public Status status;
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
