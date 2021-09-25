package jonaJmartBO;

public abstract class Complaint extends Transaction implements FileParser
{
    public int paymentId;
    public String desc;

    public Complaint(int id, Payment payment, String desc){
        super(id, 0, 0);
    }
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc){
        super(id, buyerId, storeId);
        this.paymentId = paymentId;
        this.desc = desc;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    public boolean validate(){
        return false;
    }
    public Transaction perform(){
        return null;
    }
}