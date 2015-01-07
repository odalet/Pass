package com.sopra.passport.utils;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sopra.passport.data.Date;
import com.sopra.passport.data.Sex;
import com.sopra.passport.data.User;

/**
 * Class used to save all data for a user.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserModel {

    /**
     * Id used to identify each user.
     */
	@JsonProperty("Id")
    private int id;

    /**
     * Surname of the user.
     * (ex : "MARTIN")
     */
	@JsonProperty("Surname")
    private String surname;

    /**
     * Given names of the user.
     * (ex : "Jean, Michel, Henry")
     */
	@JsonProperty("GivenNames")
    private List<String> givenNames = new ArrayList<String>();

    /**
     * Nationality of the user.
     * (ex : "French")
     */
	@JsonProperty("Nationality")
    private String nationality;

    /**
     * Sex of the user.
     */
	@JsonProperty("Sex")
    private String sex;    

    /**
     * Height of the user.
     * (ex : "1.77 m")
     */
	@JsonProperty("Height")
    private double height;
    
    /**
     * Eyes color of the user.
     */
	@JsonProperty("EyesColor")
    private String eyesColor;
    
    /**
     * Birthdate of the user.
     */
	@JsonProperty("Birthdate")
    private String birthdate;

    /**
     * Birthplace of the user.
     */
	@JsonProperty("Birthplace")
    private String birthplace;

    /**
     * Address of the user.
     */
	@JsonProperty("Address")
    private String address;

    /**
     * Photography of the user.
     */
	@JsonProperty("Photo")
    private String photo;
    
    /**
     * Signature of the user.
     */
	@JsonProperty("Signature")
    private String signature;

    /**
     * Fingerprint of the user.
     */
	@JsonProperty("Fingerprint")
    private String fingerprint;

    public UserModel() {
    	
    }
    
    public User toUser() {
    	User user = new User(id);
    	
    	user.setSurname(surname);
    	user.setGivenNames(givenNames);
    	user.setNationality(nationality);
    	
    	if (sex.compareTo(Sex.MALE.toString()) == 0) {
    		user.setSex(Sex.MALE);
    	} else {
    		user.setSex(Sex.FEMALE);
    	}
    	
    	user.setHeight(height);
    	user.setEyesColor(eyesColor);
    	user.setAddress(address);
    	user.setBirthdate(new Date(birthdate));
    	user.setBirthplace(birthplace);
    	user.setPhoto(photo.getBytes());
    	
    	return user;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getGivenNames() {
        return givenNames;
    }
    public void setGivenNames(List<String> givenNames) {
        this.givenNames = givenNames;
    }
    
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    
    public String getEyesColor() {
    	return eyesColor;
    }
    public void setEyesColor(String eyesColor) {
    	this.eyesColor = eyesColor;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
    	return photo;
    }
    
    public void setPhoto(String photo) {
    	this.photo = photo;
    }
    
    public String getSignature() {
    	return signature;
    }
    public void setSignature(String signature) {
    	this.signature = signature;
    }
    
    public String getFingerprint() {
    	return fingerprint;
    }
    public void setFingerprint(String fingerprint) {
    	this.fingerprint = fingerprint;
    }
}