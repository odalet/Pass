package com.sopra.passport.data;

import org.codehaus.jackson.annotate.JsonProperty;

public class Thumbnail {
	
	@JsonProperty("Id")
	private int id;
	@JsonProperty("MimeType")
	private String mimeType;
	@JsonProperty("Data")
	private byte[] data;
	
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
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
