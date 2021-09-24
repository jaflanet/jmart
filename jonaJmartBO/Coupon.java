package jonaJmartBO;


/**
 * Write a description of class Coupon here.
 *
 * @author (jonathan aurelius)
 * @version (12/09/21)
 */
public class Coupon
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double
    minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;  
    }
    
    public enum Type{
        DISCOUNT,
        REBATE;
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(PriceTag priceTag){
        if(priceTag.getAdjustedPrice() >= minimum && used == false){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply(PriceTag priceTag){
        this.used = true;
        if(type == Type.DISCOUNT){
            if(cut >= 100){
                return (priceTag.getAdjustedPrice() - 
                priceTag.getAdjustedPrice() * (100 / 100)); //cut max 100%
            }else if(cut <= 0){
                return (priceTag.getAdjustedPrice() - 
                priceTag.getAdjustedPrice() * (0 / 100)); //cut min 0%
            }else{
                return (priceTag.getAdjustedPrice() - 
                priceTag.getAdjustedPrice() * (cut / 100));
            }  
        }
        return (priceTag.getAdjustedPrice() - cut);
    }
}
