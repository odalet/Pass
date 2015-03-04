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
 * This class is used as a person model
 * used by the jackson mapper to get data
 * from WS used at PersonFactory class
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonModel implements Serializable {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Id used to identify each user.
	 */
	@JsonProperty("Id")
	private int id;

	/**
	 * person name
	 */
	@JsonProperty("FirstName")
	private String firstname;

	/**
	 * person last name
	 */
	@JsonProperty("LastName")
	private String lastName;

	/**
	 * person profile picture
	 */
	@JsonProperty("Thumbnail")
	private Blob thumbnail;
	/**
	 * person profile picture
	 */
	@JsonProperty("Photo")
	private Blob photo;
	/**
	 * person signature
	 */
	@JsonProperty("Signature")
	private Blob signature;
	/**
	 * person address
	 */
	@JsonProperty("Address")
	private String address;

	/**
	 * person gender
	 */
	@JsonProperty("Gender")
	private int sex;

	/**
	 * person birth date
	 */
	@JsonProperty("BirthDate")
	private String birthdate;

	/**
	 * person nationality
	 */
	@JsonProperty("Nationality")
	private String nationality;
	/**
	 * person fingerPrints
	 */
	@JsonProperty("Fingerprints")
	private ArrayList<Blob> fingerprints;
	/**
	 * person birth place
	 */
	@JsonProperty("BirthPlace")
	private String birthplace;
	/**
	 * person eyes color
	 */
	@JsonProperty("EyesColor")
	private String eyesColor;
	/**
	 * person height
	 */
	@JsonProperty("Height")
	private long height;

	public PersonModel() {

	}

	/**
	 * This function used as an adapter of personModel to person structure
	 * 
	 * @return Person
	 * @param void
	 */
	public Person toUser() {

		Person user = new Person(id);
		user.setSurname(lastName);
		ArrayList<String> list = new ArrayList<String>();
		list.add(firstname);
		user.setGivenNames(list);
		switch (sex) {
		case 0:
			user.setSex(Gender.MALE);
			break;
		case 1:
			user.setSex(Gender.FEMALE);
			break;
		default:
			user.setSex(Gender.ND);
			break;
		}
		user.setId(id);
		user.setBirthdate(new Birthdate(birthdate));

		CountryCode country = CountryCode.NOSELECTION;

		if (!nationality.isEmpty()) {
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
