package jonaJmartBO;
import java.util.regex.*;

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
    public static final String REGEX_NAME = "^[A-Z](?!\\s{2}){4,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}$";
    
    public Store(int accountId, String name, String address, String phoneNumber){
    super(accountId);
    this.name = name ;
    this.address = address;
    this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
    super(account.id);
    this.name = name ;
    this.address = address;
    this.phoneNumber = phoneNumber;
    }
    
    public boolean validate (){
    Pattern pattern_name = Pattern.compile(this.name);
    Matcher matcher_name = pattern_name.matcher(REGEX_NAME);
    Pattern pattern_phone = Pattern.compile(this.name);
    Matcher matcher_phone = pattern_name.matcher(REGEX_PHONE);
    
    if (matcher_name.find() && matcher_phone.find()){
        return true;
    }
    else {
        return false;
        }
    }
    
    @Override
    public boolean read (String content){
    return false;
    }
    
    @Override
    public String toString(){
        return
        "name : " + this.name + "\n" +
        "address: " + this.address +" \n"+
        "password: " + this.phoneNumber;
    }
}
