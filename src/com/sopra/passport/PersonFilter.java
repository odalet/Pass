package com.sopra.passport;

import java.io.Serializable;

import com.sopra.passport.data.CountryCode;
import com.sopra.passport.data.Gender;

/**
 * This class is used as a person filter. 
 * It's used by advanced search activity, and contains selected information.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class PersonFilter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Gender mSex;
	private String mFirstName;
	private String mGivenName;
	private CountryCode mNationality;
	
	public Gender getSex() {
		return mSex;
	}
	public void setSex(Gender sex) {
		this.mSex = sex;
	}
	public String getFirstName() {
		return mFirstName;
	}
	public void setFirstName(String firstName) {
		this.mFirstName = firstName;
	}
	public String getGivenName() {
		return mGivenName;
	}
	public void setGivenName(String givenName) {
		this.mGivenName = givenName;
	}
	public CountryCode getNationality() {
		return mNationality;
	}
	public void setNationality(CountryCode nationality) {
		this.mNationality = nationality;
	}
}
