package jonaJmartBO;
import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;
    public ArrayList<Record> history = new ArrayList<>();
    
    public Payment(int buyerId, int productId, int productCount,Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }
    
    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;


        public Record( Status status, String massage) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = Status.WAITING_CONFIRMATION;
            this.massage = massage;
        }

    }
    
    @Override
    public double getTotalPay(Product product) {
        return 0.0;
    }
}
