package jonaJmartBO;


/**
 * Write a description of class Product here.
 *
 * @author (jonathan aurelius)
 * @version (18/9/21)
 */
public class Product extends Recognizable implements FileParser
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
    
    public Product (int accountId, int storeId, String name, int weight, boolean conditionUsed,
    PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        
    }
    
    @Override
    public boolean read (String content){
    return false;
    }
    
    @Override
    public String toString(){
        return
        "Name : " + this.name + "\n" +
        "Weight: " + this.weight +" \n"+
        "conditionUsed: " + this.conditionUsed + " \n" +
        "priceTag: "+ this.priceTag.price +" \n" +
        "category: "+ this.category +" \n" +
        "rating: "+ this.rating.getAverage() +" \n"+
        "storeId: "+ this.accountId +" \n";
    }
}
