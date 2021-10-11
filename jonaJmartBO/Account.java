package jonaJmartBO;
import java.util.regex.*;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
   public String name ;
   public String email;
   public String password;
   public static final String REGEX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
   public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
   
   public Account(int id, String name, String email, String password){
    this.name = name;
    this.email = email;
    this.password = password;
    }
    
       public boolean validate() {
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        Pattern passPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passMatcher = passPattern.matcher(this.password);
        if(emailMatcher.find() && passMatcher.find()) {
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
        "email: " + this.email +" \n"+
        "password: " + this.password;
    }
}
