package com.jonaJmartBO;
import java.util.regex.*;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    public static final String REGEX_NAME = "^[A-Z](?!\\s{2}){4,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}$";
    
    public Store(int accountId, String name, String address, String phoneNumber, double balance){
    this.name = name ;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.balance = balance;
    }

    public boolean validate (){
    Pattern patternname = Pattern.compile(this.name);
    Matcher matchername = patternname.matcher(REGEX_NAME);
    Pattern patternphone = Pattern.compile(this.name);
    Matcher matcherphone = patternphone.matcher(REGEX_PHONE);
    
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
