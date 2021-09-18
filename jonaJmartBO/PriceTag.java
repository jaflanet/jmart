package jonaJmartBO;


/**
 * Write a description of class PriceTag here.
 *
 * @author (jonathan aurelius)
 * @version (18/9/21)
 */
public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    double price;
    
    public PriceTag(double price){
    this.price = price;
    this.discount = 0.0;
    }

    public PriceTag(double price, double discount){
    this.price = price;
    this.discount = discount; 
    }
    
    public double getAdjustedPrice(){
    return (double) getDiscountedPrice()+getAdminFee();
    }
    
    public double getAdminFee(){
          if(getDiscountedPrice()< BOTTOM_PRICE){
           return BOTTOM_FEE;
       }
       
       else{
           return getDiscountedPrice() - COMMISSION_MULTIPLIER;
       }
        
    }
    
    public double getDiscountedPrice(){
        if (discount > 100){
            return 100.0;
        }
        
        else if (discount == 100){
            return 0.0;
        }
        
        else {
            return (double) price-(price*discount);
        }  
    }
}
