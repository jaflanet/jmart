package jonaJmartBO;

public abstract class Complaint extends Recognizable implements FileParser
{
    public String desc;
    public String date = "abcd";

    public Complaint(int id, String desc){
        super(0);
        this.desc = desc;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}