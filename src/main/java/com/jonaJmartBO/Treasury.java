package com.jonaJmartBO;


/**
 * Write a description of class PriceTag here.
 *
 * @author (jonathan aurelius)
 * @version (18/9/21)
 */
public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    
    public static double getAdjustedPrice(double price, double discount){
        return (double) getDiscountedPrice(price, discount)+getAdminFee(price, discount);
    }
    
    public static double getAdminFee(double price, double discount){
        if(getDiscountedPrice(price, discount)< BOTTOM_PRICE){
           return BOTTOM_FEE;
       }
       else{
           return getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER;
       }
    }
    
    public static double getDiscountedPrice(double price, double discount){
        if (discount > 100){
            discount = 100.0;
        }
        if (discount == 100){
            return 0.0;
        }
        else {
            return  price * ((100.0 - discount)/100.0);
        }  
    }
}
