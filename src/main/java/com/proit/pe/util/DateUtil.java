package com.proit.pe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public String pattern = "dd/MM/yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    
    public String toString(Date date){
        return sdf.format(date);
    }
    
    public Date toDate(String stDate) throws ParseException{
        return sdf.parse(stDate);
    }
}
