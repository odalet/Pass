package com.sopra.passport.data;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class contains an image and this meta-data.
 * 
 * @author Corentin CHEMINAUD
 * @author Mohammed EL GADI
 */
public class Blob implements Serializable {

	private static final long serialVersionUID = 2L;

	/**
	 * Id used to identify the image
	 */
	@JsonProperty("Id")
	private int id;
	
	/**
	 * Finger number
	 */
	@JsonProperty("Finger")
	private int finger;
	
	/**
	 * Mime type
	 */
	@JsonProperty("MimeType")
	private String mimeType;
	
	/**
	 * Data
	 */
	@JsonProperty("Data")
	private String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getFinger() {
		return finger;
	}
	public void setFinger(int finger) {
		this.finger = finger;
	}
	
	
	
	
}
