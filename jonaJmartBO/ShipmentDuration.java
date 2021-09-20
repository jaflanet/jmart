package jonaJmartBO;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (jonathan aurelius)
 * @version (12/09/21)
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = 
    new ShipmentDuration (1 << 0);
    public static final ShipmentDuration SAME_DAY =
    new ShipmentDuration (1 << 1);
    public static final ShipmentDuration NEXT_DAY = 
    new ShipmentDuration (1 << 2);
    public static final ShipmentDuration REGULER = 
    new ShipmentDuration (1 << 3);
    public static final ShipmentDuration Kargo= 
    new ShipmentDuration (1 << 4);
    private final int bit;

    private ShipmentDuration(int bit){
        this.bit = bit; 
    }
    
    public ShipmentDuration(int... args){
        int flag = 0;
        for (int i:args){
        flag = flag|i;
        }
        this.bit = flag;
    }
    
    public boolean isDuration(ShipmentDuration shipmentDuration){
        return false;
    }
}
