package jonaJmartBO;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Transaction extends Recognizable
{
    public String time = "TIME";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
    
    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, Store store){
        super(id);
    }
    
    public abstract boolean validate();
    public abstract Transaction perfor();
}
