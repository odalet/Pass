package com.sopra.passport;

import java.io.Serializable;

import com.sopra.passport.data.CountryCode;
import com.sopra.passport.data.Gender;


/**
 * This class is used as a person filter 
 * its used by advanced search activity, 
 * and contains selected information.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */

public class PersonFilter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Gender sex;
	private String firstName;
	private String givenName;
	private CountryCode nationality;
	
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public CountryCode getNationality() {
		return nationality;
	}
	public void setNationality(CountryCode nationality) {
		this.nationality = nationality;
	}
}
