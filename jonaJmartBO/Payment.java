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
    public Payment(int id, int buyerId, int productId, Shipment shipment){
        super(id, buyerId, 0);
        this.shipment = shipment;
    }
    @Override
    public double getTotalPay() {
        return 0.0;
    }
}
