package jonaJmartBO;
import java.util.regex.*;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable
{
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_NAME = "^[A-Z](?!\\s{2}){4,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}$";
    
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
    
    public boolean validate (){
    Pattern patternname = Pattern.compile(this.name);
    Matcher matchername = patternname.matcher(REGEX_NAME);
    Pattern patternphone = Pattern.compile(this.name);
    Matcher matcherphone = patternname.matcher(REGEX_PHONE);
    
    if (matchername.find() && matcherphone.find()){
        return true;
    }
    else {
        return false;
        }
    }
    
    
    @Override
    public String toString(){
        return
        "name : " + this.name + "\n" +
        "address: " + this.address +" \n"+
        "password: " + this.phoneNumber;
    }
}
