package com.jonaJmartBO.controller;
import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;
import com.jonaJmartBO.*;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
 public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class, filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\account.json")
    public static JsonTable<Account> accountTable;
 
 @Override
 public JsonTable<Account> getJsonTable(){
  return accountTable;
 }
 
 @GetMapping
 String index() { return "account page"; }
 
 @PostMapping("/register")
 Account register
 (
     @RequestParam String name,
     @RequestParam String email,
     @RequestParam String password
 )
 {
     if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
         for(Account account : accountTable){
             if(account.email.equals(email)){
                 return account;
             }
         }
         try {
             MessageDigest md;
             md = MessageDigest.getInstance("MD5");
             byte[] messageDigest = md.digest(password.getBytes());
             BigInteger no = new BigInteger(1, messageDigest);
             String hashtext = no.toString(16);
             while (hashtext.length() < 32) {
                 hashtext = "0" + hashtext;
             }
             getJsonTable().add(new Account(name, email, hashtext, 0));
             return new Account(name, email, password, 0);
         } catch (NoSuchAlgorithmException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         
     }
     
     return new Account(name, email, password, 0);
 }
 
 @PostMapping("/login")
 Account login
 (
  @RequestParam String email,
  @RequestParam String password
 )
 {
  String generatedPassword;
  try {
   MessageDigest md = MessageDigest.getInstance("MD5");
     
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++)
             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            
            generatedPassword = sb.toString();
  }
  catch(NoSuchAlgorithmException e) {
   throw new RuntimeException(e);
  }
  for(Account account : accountTable)
        {
            if (account.email.equals(email) && account.password.equals(generatedPassword))
                return account;
        }
        return null;
 }
 
 @PostMapping("/{id}/registerStore")
 Store registerStore(
   @PathVariable int id,
   @RequestParam String name,
   @RequestParam String address,
   @RequestParam String phoneNumber
   ) {
  Account acc = Algorithm.<Account>find(getJsonTable(), (account -> account.id == id && account.store == null));
  acc.store = new Store(name, address, phoneNumber, 0);
  return acc.store;
 }
 
 @PostMapping("/{id}/topUp")
 boolean topUp(@PathVariable int id, @RequestParam double balance){
  Account acc = Algorithm.<Account>find(getJsonTable(), (account -> account.id == id));
  acc.balance += balance;
  return Algorithm.<Account>exists(getJsonTable(), (account -> account.id == id));
 }
}
