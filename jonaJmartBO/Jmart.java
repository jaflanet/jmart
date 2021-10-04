package jonaJmartBO;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jmart
{
    
  public static void main (String args[]){
        
        /*System.out.println(getPromo());
        System.out.println(getCustomer());
        System.out.println(getDiscountPercentage(1000,900));
        System.out.println(getDiscountedPrice(1000,10.0f));
        System.out.println(getOriginalPrice(900,10.0f));
        System.out.println(getAdminFee(1000));
        System.out.println(getCommisionMultiplier());
        */
        Account account = new Account(1, "supriyono", "supri..yono@ui.ac.id", "Supriyono123");
        System.out.println(account.validate());
    }
 
 
    public static Product createProduct(){
        return null;
    }
    
    public static Coupon createCoupun(){
        return null;
    }
    
    public static Shipment.Duration Duration(){
        return null;
    }
    /* 
  public static int getPromo(){
      return 0;
  }
  
  public static String getCustomer(){
      return "oop";
  }
  
  public static float getDiscountPercentage(int before, int after){
      if (before < after) {
          return 0.0f;
      }
      
      return (float) (before - after) / before*100;
  }
  
  public static int getDiscountedPrice(int price, float discountPercentage){
      if (discountPercentage > 100.0f) {
          return 0;
      }
      float priceFloat = (float)price;
      
      return (int) (priceFloat - (priceFloat * discountPercentage / 100));
  }
  
  public static int getOriginalPrice(int discountedPrice, float discountPercentage){
      float discountedPriceFloat = (float)discountedPrice;
      
      return (int) (discountedPriceFloat * (100 / (100 - discountPercentage))) ;
  }
  
  public static float getCommisionMultiplier(){
      return 0.05f;
  }
  
  public static int getAdjustedPrice(int price){
      float priceFloat = (float)price;
      
      return (int) (priceFloat + ( priceFloat * getCommisionMultiplier() ) );
  }
  
  public static int getAdminFee(int price){
      float priceFloat = (float)price;
      return (int) (priceFloat * getCommisionMultiplier());
  }
  */
}
