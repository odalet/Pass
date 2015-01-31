package com.sopra.passport.data;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sopra.passport.utils.ImageConverter;

public class Blob implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@JsonProperty("Id")
	private int id;
	
	@JsonProperty("Finger")
	private int finger;
	
	@JsonProperty("MimeType")
	private String mimeType;
	
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
