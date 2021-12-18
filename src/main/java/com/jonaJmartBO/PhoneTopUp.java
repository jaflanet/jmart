package com.jonaJmartBO;

/**
 * @author Jona
 * @version 18/12/21
 */

public class PhoneTopUp extends Invoice {
	public String phoneNumber;
	public String status;
	
	public PhoneTopUp (int buyerId, int productId, String phoneNumber) {
		super(buyerId, 0);
		this.productId = productId;
		this.phoneNumber = phoneNumber;
	}
	
    @Override
    public double getTotalPay(Product product) {
    	return Treasury.getAdjustedPrice(product.price, product.discount);
    }
	
}
