package jonaJmartBO;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Calendar;


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
    public static final Duration KARGO =  new Duration ((byte) (1<< 4));
    public final byte bit;
    public static final SimpleDateFormat ESTIMATION_FORMAT 
    = new SimpleDateFormat("E MMMM dd yyyy");

    private Duration(byte bit){
        this.bit = bit;
        }
    
    public String getEstimatedArrival (Date reference){
        if (this.bit == INSTANT.bit || this.bit == SAME_DAY.bit){
            return ESTIMATION_FORMAT.format(reference);
        }
        
        else if (this.bit == NEXT_DAY.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }
        
        else if (this.bit == REGULER.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }
        else{
            return ESTIMATION_FORMAT.format(reference.getDay() + 5); 
        }
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


