package jonaJmartBO;


/**
 * Write a description of class Product here.
 *
 * @author (jonathan aurelius)
 * @version (18/9/21)
 */
public class Product extends Recognizable implements FileParser
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product (int id, int storeId, String name, int weight, boolean conditionUsed,
    PriceTag priceTag, ProductCategory category){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.storeId = storeId;
    }
    
    Product(int id, Store store, String name, int weight, boolean conditionUsed,
    PriceTag priceTag, ProductCategory category){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }
    
     @Override
       public boolean read (String content){
       return false;
    }
}
