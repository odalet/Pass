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
 * Class used to save all data for a user.
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * Id used to identify each user.
     */
    private int id;

    /**
     * Surname of the user.
     * (ex : "MARTIN")
     */
    private String surname;

    /**
     * Given names of the user.
     * (ex : "Jean, Michel, Henry")
     */
    private List<String> givenNames = new ArrayList<String>();

    /**
     * Nationality of the user.
     * (ex : "French")
     */
    private CountryCode nationality;

    /**
     * Sex of the user.
     */
    private Gender sex;    

    /**
     * Height of the user.
     * (ex : "1.77 m")
     */
    private double height;
    
    /**
     * Eyes color of the user.
     */
    private String eyesColor;
    
    /**
     * Birthdate of the user.
     */
    private Birthdate birthdate;

    /**
     * Birthplace of the user.
     */
    private String birthplace;

    /**
     * Address of the user.
     */
    private String address;

    /**
     * Photography of the user.
     */
    private Blob photo;
    
    /**
     * Signature of the user.
     */
    private Blob signature;

    /**
     * Fingerprint of the user.
     */
    private ArrayList<Blob> fingerprints;
    
    
    /**
     * 
     * thumbailNail of the user
     */
    private Blob thumbnail; 
    

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
    	return ImageConverter.getBitmap(photo);
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
		    if (out != null) {
		      out.close();
		    }
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
	
	public static Person deserialise(byte [] bpreson) throws StreamCorruptedException, IOException, ClassNotFoundException{
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
				    if (in != null) {
				      in.close();
				    }
				  } catch (IOException ex) {
				    throw ex;
				  }
				}
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
		return  bperson;
		
	}
	
	public boolean filter(PersonFilter fCriteria){
		boolean ret = false;
		if (fCriteria.getNationality().equals(nationality) && fCriteria.getSex().equals(sex)){
			if(fCriteria.getFirstName().isEmpty() && fCriteria.getGivenName().isEmpty()){
				ret = true;
			}else if (fCriteria.getFirstName() != null && !fCriteria.getFirstName().isEmpty()
					&&fCriteria.getGivenName() != null && !fCriteria.getGivenName().isEmpty()){
				
				for(String iterator : givenNames){
					if(iterator.toLowerCase().contains(fCriteria.getGivenName().toLowerCase())){
						ret = fCriteria.getFirstName().toLowerCase().contains(surname.toLowerCase());
					}
				}
			
			}else if((fCriteria.getFirstName()== null || fCriteria.getFirstName().isEmpty())){
				for(String strIterator : givenNames){
					if(strIterator.toLowerCase().contains(fCriteria.getGivenName().toLowerCase())){
						ret = true;
					}
				}
			}else if((fCriteria.getGivenName() == null || fCriteria.getGivenName().isEmpty()) && fCriteria.getFirstName().toLowerCase().contains(surname.toLowerCase())) {
				ret = true;
			}	
		}
		
		return ret;
	}
	
	
	
	
	
	
	
}
