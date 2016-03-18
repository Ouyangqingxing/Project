package com.wy;

import java.text.DateFormat;
import java.util.Date;



public class CountTime {
	public String currentlyTime(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
	}
}
