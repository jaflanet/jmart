package jonaJmartBO;


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
   
   public Account(int id, String name, String email, String password){
    super(id);
    this.name = name;
    this.email = email;
    this.password = password;
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
