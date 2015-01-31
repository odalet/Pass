package com.sopra.passport.utils;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
public class PersonModel {

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
    	user.setBirthdate(new Birthdate(birthdate));
    	user.setNationality(country.getCountrName());
    	user.setAddress(address);
    	user.setPhoto(photo);
    	user.setFingerprints(fingerprints);
    	user.setSignature(signature);
 
    	/*
    	user.setHeight(height);
    	user.setEyesColor(eyesColor);
    	
    	user.setBirthplace(birthplace);
    	
    	try {
			Bitmap image = ImageConverter.getBitmapFromJPEG2000Bytes(photo.getBytes());
    		user.setPhoto(ImageConverter.getBytesFromBitmap(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		Bitmap image = ImageConverter.getBitmapFromJPEG2000Bytes(signature.getBytes());
    		user.setSignature(ImageConverter.getBytesFromBitmap(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		Bitmap image = ImageConverter.getBitmapFromWSQBytes(fingerprint.getBytes());
    		user.setFingerprint(ImageConverter.getBytesFromBitmap(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	
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

    /*
	private Map<Integer,Blob> getListFingerPrints(){
		if (fingerprints == null || fingerprints.size() == 0 ){
			return null;
		}
		
		Map<Integer,Blob> map = new HashMap<Integer, Blob>();
		
		for (Blob biterator : fingerprints ){
			map.put(biterator.getFinger(), biterator)
		}
		
		return map;
	}
	*/
	
	
	
}
