package com.sopra.passport.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

import com.sopra.passport.PersonFilter;
import com.sopra.passport.utils.ImageConverter;

/**
 * This class contains all data for a person.
 * 
 * @author Corentin CHEMINAUD
 * @author Mohammed EL GADI
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * Id used to identify each person.
     */
    private int id;

    /**
     * Surname of the person.
     * (ex : "MARTIN")
     */
    private String surname;

    /**
     * Given names of the person.
     * (ex : "Jean, Michel, Henry")
     */
    private List<String> givenNames = new ArrayList<String>();

    /**
     * Nationality of the person.
     * (ex : "French")
     */
    private CountryCode nationality;

    /**
     * Sex of the person.
     */
    private Gender sex;    

    /**
     * Height of the person.
     * (ex : "1.77 m")
     */
    private double height;
    
    /**
     * Eyes color of the person.
     */
    private String eyesColor;
    
    /**
     * Birthdate of the person.
     */
    private Birthdate birthdate;

    /**
     * Birthplace of the person.
     */
    private String birthplace;

    /**
     * Address of the person.
     */
    private String address;

    /**
     * Photography of the person.
     */
    private Blob photo;
    
    /**
     * Signature of the person.
     */
    private Blob signature;

    /**
     * Fingerprint of the person.
     */
    private ArrayList<Blob> fingerprints;
    
    
    /**
     * Thumbnail of the person.
     */
    private Blob thumbnail;
    
    public boolean isCharged = false;

    public Person(int id) {

    }

    public Person() {
    	
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
    
    public CountryCode getNationality() {
        return nationality;
    }
    public void setNationality(CountryCode nationality) {
        this.nationality = nationality;
    }

    public Gender getSex() {
        return sex;
    }
    public void setSex(Gender sex) {
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
    
    public Birthdate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Birthdate birthdate) {
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

    public Blob getPhoto() {
    	return photo;
    }
    
    public Bitmap getPhotoToBitmap() throws IOException {
    	return ImageConverter.getBitmap(thumbnail);
    }
    
    public void setPhoto(Blob photo) {
    	this.photo = photo;
    }
    

    public Bitmap getSignatureToBitmap() throws IOException {
    	return ImageConverter.getBitmap(signature);
    }
    public void setSignature(Blob signature) {
    	this.signature = signature;
    }
    
    public Blob getSignature() {
    	return signature;
    }
   
	public Blob getThumbnail() {
		return thumbnail;
	}
	
	public Bitmap getThumbnailToBitmap() throws IOException {
	    	return ImageConverter.getBitmap(thumbnail);
	    }

	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ArrayList<Blob> getFingerprints() {
		return fingerprints;
	}

	public void setFingerprints(ArrayList<Blob> fingerprints) {
		this.fingerprints = fingerprints;
	}


	public static byte[] serialize(Person p) throws IOException{
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		byte[] yourBytes = null;
		
		try {
			out = new ObjectOutputStream(bos);   
			out.writeObject(p);
			yourBytes = bos.toByteArray();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ex) {
				// ignore close exception
			}
			
			try {
				bos.close();
			} catch (IOException ex) {
				// ignore close exception
			}
		}
		
		return yourBytes;
	}
	
	public static Person deserialise(byte [] bpreson) 
			throws StreamCorruptedException, IOException, ClassNotFoundException{
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bpreson);
		ObjectInput in = null;
		Person bperson = null;
		
		try{
			try {
				in = new ObjectInputStream(bis);
				bperson = (Person)in.readObject(); 
			} finally {
				try {
					bis.close();
				} catch (IOException ex) {
					throw ex;
				}
				try {
					if (in != null)
						in.close();
				} catch (IOException ex) {
				    throw ex;
				}
			}
		} catch(Exception exp){
			exp.printStackTrace();
		}
		
		return  bperson;
	}
	
	public boolean filter(PersonFilter fCriteria) {
		boolean ret = false;

		boolean condition = fCriteria.getNationality().equals(nationality) && fCriteria.getSex()== sex;
		condition = condition || (fCriteria.getNationality() == CountryCode.NOSELECTION && fCriteria.getSex()== sex);
		condition = condition || (fCriteria.getNationality().equals(nationality) && fCriteria.getSex()== Gender.ND);
		
		if (condition){
			if(fCriteria.getFirstName().isEmpty() && fCriteria.getGivenName().isEmpty()){
				ret = true;
			} else if (fCriteria.getFirstName() != null && !fCriteria.getFirstName().isEmpty()
					&& fCriteria.getGivenName() != null && !fCriteria.getGivenName().isEmpty()){
				
				for(String iterator : givenNames){
					if(iterator.toLowerCase().contains(fCriteria.getGivenName().toLowerCase()))
						ret = fCriteria.getFirstName().toLowerCase().contains(surname.toLowerCase());
				}
			
			} else if((fCriteria.getFirstName()== null || fCriteria.getFirstName().isEmpty())){
				
				for(String strIterator : givenNames){
					if(strIterator.toLowerCase().contains(fCriteria.getGivenName().toLowerCase()))
						ret = true;
				}
				
			} else if((fCriteria.getGivenName() == null || fCriteria.getGivenName().isEmpty()) 
					&& surname.toLowerCase().contains(fCriteria.getFirstName().toLowerCase())) {
				ret = true;
			}	
		}
		
		return ret;
	}
	
	public static Person combine(Person firstPerson, Person secondPerson) {
		Person person = secondPerson;
		secondPerson = firstPerson;
		firstPerson.thumbnail = person.thumbnail;
		firstPerson.isCharged = true;
		return firstPerson;
	}
}
