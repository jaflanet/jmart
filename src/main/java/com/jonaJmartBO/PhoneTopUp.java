package com.jonaJmartBO;

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
        return 0.0;
    }
	
}
