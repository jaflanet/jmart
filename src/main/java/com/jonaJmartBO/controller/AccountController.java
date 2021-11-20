package com.jonaJmartBO.controller;
import com.jonaJmartBO.Account;
import com.jonaJmartBO.Store;
import com.jonaJmartBO.dbjson.JsonAutowired;
import com.jonaJmartBO.dbjson.JsonTable;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	 public static final String REGEX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	 public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
	 public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	 public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	 public static @JsonAutowired(filepath = "C:\\Users\\Jona\\Desktop\\KULIAH SEM 5\\praktikum oop\\modul 1\\jmart\\src\\main\\java\\com\\json\\account.json", value = Account.class)JsonTable<Account> accountTable;
	 
	 
	 public JsonTable<Account> getJsonTable(){
	        return accountTable;
	    }
	@GetMapping
	String index() { return "account page"; }
	
	@PostMapping("/login")
	Account login
	(
		@RequestParam String email,
		@RequestParam String password
	)
	{
        for(Account acc : accountTable){
            if(acc.email.equals(email) && acc.password.equals(password)){
                return acc;
            }
        }
        return null;
    }
	
	@PostMapping("/register")
    Account register
            (       String name, 
            		String email, 
            		String password
            )
    {
        if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
            for(Account account : accountTable){
                if(account.email.equals(email)){
                    return null;
                }
            }
            return new Account(name, email, password, 0);
        }
        return null;
    }
	
	@PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null){
            Store addStore = new Store(name, address, phoneNumber, 0);
            accountTable.get(id).store = addStore;
            return addStore;
        }else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance){
        if(accountTable.contains(accountTable.get(id))){
            accountTable.get(id).balance += balance;
            return true;
        }else{
            return false;
        }

    }
//	@GetMapping("/{id}")
//	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }

//	@Override
//	public JsonTable<Account> getJsonTable() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}