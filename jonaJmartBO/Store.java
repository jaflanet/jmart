package jonaJmartBO;


/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber){
    this.name = name ;
    this.address = address;
    this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
    this.name = name ;
    this.address = address;
    this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read (String content){
    return false;
    }
}
