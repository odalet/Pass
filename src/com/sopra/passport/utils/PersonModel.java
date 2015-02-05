package com.sopra.passport.utils;

import java.io.Serializable;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import com.sopra.passport.data.Birthdate;
import com.sopra.passport.data.Blob;
import com.sopra.passport.data.CountryCode;
import com.sopra.passport.data.Gender;
import com.sopra.passport.data.Person;

/**
 * Class used to save all data for a user.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Id used to identify each user.
     */
	@JsonProperty("Id")
    private int id;

	@JsonProperty("FirstName")
    private String firstname;

	@JsonProperty("LastName")
	private String lastName;
	
	
	@JsonProperty("Thumbnail")
	private Blob thumbnail;
	
	@JsonProperty("Photo")
	private Blob photo;
	
	@JsonProperty("Signature")
	private Blob signature;
	/*
	@JsonProperty("Signature")
	private List<Blob> fingerprints;
	*/
	@JsonProperty("Address")
	private String address;
	

	@JsonProperty("Gender")
    private Gender sex;    
    
    
	@JsonProperty("BirthDate")
    private String birthdate;
	
	@JsonProperty("Country")
    private CountryCode country;
	
	@JsonProperty("Fingerprints")
	private ArrayList<Blob> fingerprints;

    public PersonModel() {
    	
    }
    
    
    public Person toUser() {
  
    		
    		Person user = new Person(id);
        	
        	user.setSurname(lastName);
        	ArrayList<String> list = new ArrayList<String>();
        	list.add(firstname);
        	user.setGivenNames(list);
        	
        	if (sex == Gender.MALE) {
        		user.setSex(Gender.MALE);
        	} else {
        		user.setSex(Gender.FEMALE);
        	}
        	user.setId(id);
        	user.setBirthdate(new Birthdate(birthdate));
        	if(country == null){
        		country = CountryCode.NOSELECTION;
        	}
        	user.setNationality(country);
        	user.setAddress(address);
        	user.setPhoto(photo);
        	user.setFingerprints(fingerprints);
        	user.setSignature(signature);
        	return user;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Blob getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}


	public Blob getPhoto() {
		return photo;
	}


	public void setPhoto(Blob photo) {
		this.photo = photo;
	}


	public Blob getSignature() {
		return signature;
	}


	public void setSignature(Blob signature) {
		this.signature = signature;
	}

	public Gender getSex() {
		return sex;
	}


	public void setSex(Gender sex) {
		this.sex = sex;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public CountryCode getCountry() {
		return country;
	}


	public void setCountry(CountryCode country) {
		this.country = country;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public ArrayList<Blob> getFingerprints() {
		return fingerprints;
	}


	public void setFingerprints(ArrayList<Blob> fingerprints) {
		this.fingerprints = fingerprints;
	}

	
	
	
}
