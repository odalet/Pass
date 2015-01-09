package com.sopra.passport.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

import com.sopra.passport.utils.ImageConverter;

/**
 * Class used to save all data for a user.
 */
public class User implements Serializable {

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
    private String nationality;

    /**
     * Sex of the user.
     */
    private Sex sex;    

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
    private Date birthdate;

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
    private byte[] photo;
    
    /**
     * Signature of the user.
     */
    private byte[] signature;

    /**
     * Fingerprint of the user.
     */
    private byte[] fingerprint;

    public User(int id) {

    }

    public User() {
    	
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

    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
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
    
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
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

    public byte[] getPhoto() {
    	return photo;
    }
    public Bitmap getPhotoToBitmap() {
    	return ImageConverter.getBitmapFromBytes(photo, ImageConverter.ImageFormat.JPEG_FORMAT);
    }
    
    public void setPhoto(byte[] photo) {
    	this.photo = photo;
    }
    
    public byte[] getSignature() {
    	return signature;
    }
    public Bitmap getSignatureToBitmap() {
    	return ImageConverter.getBitmapFromBytes(signature, ImageConverter.ImageFormat.JPEG_2000_FORMAT);
    }
    public void setSignature(byte[] signature) {
    	this.signature = signature;
    }
    
    public byte[] getFingerprint() {
    	return fingerprint;
    }
    public void setFingerprint(byte[] fingerprint) {
    	this.fingerprint = fingerprint;
    }
}
