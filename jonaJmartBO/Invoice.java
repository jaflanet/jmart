package jonaJmartBO;
import java.util.Date;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Jonathan Aurelius)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
   public Date date;
   public int buyerId;
   public int productId;
   public int complaintId;
   public Rating rating;
   public Status status;
   
   public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }

   public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED; 
   }
   
   protected Invoice(int id,int productId, int buyerId){
       super(id);
       this.buyerId = buyerId;
       this.productId = productId;
       this.date = new Date();
       this.rating = Rating.NONE;
       this.status = Status.WAITING_CONFIRMATION;
    }
    
   public abstract double getTotalPay();
   
   @Override
    public boolean read(String content) {
        return false;
    }
}
