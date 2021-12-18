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
	 public static @JsonAutowired(value=Account.class, filepath="C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\account.json") JsonTable<Account> accountTable;
	    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
	    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
	    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

	    public JsonTable<Account> getJsonTable(){
	        return accountTable;
	    }

	    @PostMapping("/login")
	    Account login
	            (
	                    @RequestParam String email,
	                    @RequestParam String password
	            )
	    {
	        for(Account account : accountTable){
	            try{
	                MessageDigest md = MessageDigest.getInstance("MD5");
	                md.update(password.getBytes());
	                byte[] bytes = md.digest();
	                StringBuilder sb = new StringBuilder();
	                for(int i = 0; i < bytes.length; i++){
	                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	                }
	                if(account.email.equals(email) && account.password.equals(sb.toString())){ //Compare hash in string with equals
	                    return account;
	                }
	            } catch (NoSuchAlgorithmException e){
	                e.printStackTrace();
	            }

	        }
	        return null;
	    }

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
	                    return null;
	                }
	            }
	            try{
	                MessageDigest md = MessageDigest.getInstance("MD5");
	                md.update(password.getBytes());
	                byte[] bytes = md.digest();
	                StringBuilder sb = new StringBuilder();
	                for(int i = 0; i < bytes.length; i++){
	                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	                }
	                Account newAccount = new Account(name, email, sb.toString(), 0);
	                accountTable.add(newAccount);
	                return newAccount;
	            }catch (NoSuchAlgorithmException e){
	                e.printStackTrace();
	            }
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
	    Account topUp(@PathVariable int id, @RequestParam double balance){
	     Account acc = Algorithm.<Account>find(getJsonTable(), (account -> account.id == id));
	     acc.balance += balance;
	     return acc;
	   //  return Algorithm.<Account>exists(getJsonTable(), (account -> account.id == id));
	    }
}
