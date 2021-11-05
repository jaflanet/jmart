package jonaJmartBO;


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
    
    public Payment(int buyerId, int productId, int productCount,Shipment shipment){
        super(buyerId, 0);
        this.shipment = shipment;
        this.productCount = productCount;
    }
    @Override
    public double getTotalPay() {
        return 0.0;
    }
}
