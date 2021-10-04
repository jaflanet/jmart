package jonaJmartBO;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Complaint extends Recognizable implements FileParser
{
    public String desc;
    public final Date date;

    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateToStringFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateToStringFormatter.format(this.date);
        String desc = this.desc;
        return "date="+ date + ",desc='" + desc +"'";
    }
}