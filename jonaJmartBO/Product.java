package jonaJmartBO;


/**
 * Write a description of class Product here.
 *
 * @author (jonathan aurelius)
 * @version (18/9/21)
 */
public class Product
{
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionedUsed, PriceTag
    priceTag, ProductCategory category){
        this.name=name;
        this.weight=weight;
        this.conditionUsed=conditionedUsed;
        this.priceTag= priceTag;
        this.category=category;
        this.rating=new ProductRating();
        idCounter++;
        this.id = idCounter;    
    }
    
    
    
}
