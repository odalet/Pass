package com.sopra.passport.data;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * This class represents a specific date.
 *
 * It allows the interpretation of date as year, month and day.
 * Each field can be empty.
 */
public class Birthdate implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constant used if a field is not completed.
	 */
	private static final int NONE = -1;
	
	/**
	 * Day of the month (1 to 31).
	 */
	private int day;
	
	/**
	 * Month (1 to 12).
	 */
	private int month;
	
	/**
	 * Year.
	 */
	private int year;
	
	public Birthdate() {
		this.day = Birthdate.NONE;
		this.month = Birthdate.NONE;
		this.year = Birthdate.NONE;
	}
	
	public Birthdate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Birthdate(String date) {
		StringTokenizer strTk = new StringTokenizer(date, "/");
		
		String dayStr = strTk.nextElement().toString();
		try {
			this.day = Integer.parseInt(dayStr);
		} catch(NumberFormatException ex) {
			this.day = -1;
		}
		
		String monthStr = strTk.nextElement().toString();
		try {
			this.month = Integer.parseInt(monthStr);
		} catch(NumberFormatException ex) {
			this.day = -1;
		}
		
		String yearStr = strTk.nextElement().toString();
		this.year = Integer.parseInt(yearStr);
	}
	
	public String toString() {
		StringBuffer buff = new StringBuffer();
		
		buff.append((day == Birthdate.NONE) ? "--" : day);
		buff.append('/');
		buff.append((month == Birthdate.NONE) ? "--" : month);
		buff.append('/');
		buff.append((year == Birthdate.NONE) ? "----" : year);
		
		return buff.toString();
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
