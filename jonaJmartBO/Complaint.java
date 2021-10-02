package jonaJmartBO;
import java.util.Date;


public class Complaint extends Recognizable implements FileParser
{
    public String desc;
    public Date date;

    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}