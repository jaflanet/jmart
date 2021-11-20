package com.jonaJmartBO;
import java.util.regex.*;

import com.jonaJmartBO.dbjson.Serializable;


/**
 * Write a description of class Account here.
 *
 * @author Jonathan Aurelius F
 * @version 02/11/21
 */
public class Account extends Serializable
{
   public String name ;
   public String email;
   public String password;
   public double balance;
   public Store store;
   public static final String REGEX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
   public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
   
   public Account(String name, String email, String password, double balance){
    this.name = name;
    this.email = email;
    this.password = password;
    this.balance = balance;
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
    public String toString(){
        return
        "name : " + this.name + "\n" +
        "email: " + this.email +" \n"+
        "password: " + this.password;
    }
}
