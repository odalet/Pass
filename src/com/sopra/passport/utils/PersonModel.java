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
    private int sex;    
    
    
	@JsonProperty("BirthDate")
    private String birthdate;
	
	
	@JsonProperty("Nationality")
    private String nationality;
	
	@JsonProperty("Fingerprints")
	private ArrayList<Blob> fingerprints;
	
	@JsonProperty("BirthPlace")
	private String birthplace;

	@JsonProperty("EyesColor")
	private String eyesColor;
	
	@JsonProperty("Height")
	private long height;
	
	
	
    public PersonModel() {
    	
    }
    
public Person toUser() {
    	  
		
		Person user = new Person(id);
    	
    	user.setSurname(lastName);
    	ArrayList<String> list = new ArrayList<String>();
    	list.add(firstname);
    	user.setGivenNames(list);
    	switch (sex) {
		case 0 :
			user.setSex(Gender.MALE);
			break;
		case 1 :
    		user.setSex(Gender.FEMALE);
			break;
		default :
    		user.setSex(Gender.ND);
			break;
    	}
    	user.setId(id);
    	user.setBirthdate(new Birthdate(birthdate));

    	CountryCode country = CountryCode.NOSELECTION;
    	
    	if(!nationality.isEmpty()){
    		country = CountryCode.getByCode(nationality);
    	}
    	
    	
    	user.setAddress(address);
    	user.setPhoto(photo);
    	user.setFingerprints(fingerprints);
    	user.setSignature(signature);
    	user.setThumbnail(thumbnail);
    	user.setBirthplace(birthplace);
    	user.setEyesColor(eyesColor);
    	user.setHeight(height);
    	user.setNationality(country);
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

	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	
    public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
}
