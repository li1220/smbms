package cn.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeUtil {
	
	public static Date parse(String strDate)throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(strDate);
	}
	
	public static int getAge(Date birthday)throws Exception {
		Calendar cal=Calendar.getInstance();
		if (cal.before(birthday)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthday);   
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);   
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
		
	}
	
}
