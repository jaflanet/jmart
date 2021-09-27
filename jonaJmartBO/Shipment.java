package jonaJmartBO;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    public String address ;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
   
    @Override
    public boolean read(String content){
        return false;
    }
    
    public static class Duration
    {   
    public static final Duration INSTANT = new Duration ((byte) (1<<0));
    public static final Duration SAME_DAY = new Duration ((byte)(1<<1));
    public static final Duration NEXT_DAY = new Duration ((byte)(1<<2));
    public static final Duration REGULER =  new Duration ((byte)(1<<3));
    public static final Duration Kargo =  new Duration ((byte) (1<< 4));
    public byte bit;

    private Duration(byte bit){
        this.bit = bit; 
    }
    }
    
    public class MultiDuration{
    public byte bit;
    
    public MultiDuration(Duration ... args){
        byte  flag = 0;
        for (Duration  i:args){
            flag |= i.bit;
        }
        this.bit = flag;
    }
    
    public boolean isDuration(Duration Duration){
        if((bit & Duration.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    }
}


