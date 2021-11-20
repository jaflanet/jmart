package com.jonaJmartBO;
import java.util.Date;

import com.jonaJmartBO.dbjson.Serializable;

import java.text.SimpleDateFormat;


public class Complaint extends Serializable
{
    public String desc;
    public final Date date;

    public Complaint(int id, String desc){
        this.desc = desc;
        this.date = new Date();
    }
    
    
    @Override
    public String toString(){
        SimpleDateFormat dateToStringFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateToStringFormatter.format(this.date);
        String desc = this.desc;
        return "date="+ date + ",desc='" + desc +"'";
    }
}