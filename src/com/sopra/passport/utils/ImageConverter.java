package com.sopra.passport.utils;


import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;

public class ImageConverter {

	public enum ImageFormat {
		PNG_FORMAT,
		JPEG_FORMAT,
		JPEG_2000_FORMAT
	}
	
	static public byte[] getBytesFromBitmap(Bitmap bitmap) {
	    ByteArrayOutputStream stream = new ByteArrayOutputStream();
	    bitmap.compress(CompressFormat.JPEG, 70, stream);
	    
	    return Base64.encode(stream.toByteArray(), Base64.NO_WRAP);
	}
	
	static public Bitmap getBitmapFromBytes(byte[] encodedImage, ImageFormat format){
		byte[] base64Bytes = Base64.decode(encodedImage, Base64.DEFAULT);
		Bitmap decodedBytes = null;
		
		switch(format) {
		
		case JPEG_2000_FORMAT:

			break;
			
		case PNG_FORMAT:
		case JPEG_FORMAT:
		default:
			decodedBytes = BitmapFactory.decodeByteArray(base64Bytes, 0, base64Bytes.length);
			break;
		}
		
		 
		
		return decodedBytes;
	}
}
