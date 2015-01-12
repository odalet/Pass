package com.sopra.passport.utils;
import jj2000.JJ2000Frontend;
import jj2000.j2k.decoder.Decoder;
import jj2000.j2k.util.ParameterList;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;

public class ImageConverter {

	public static enum ImageFormat {
		PNG_FORMAT,
		JPEG_FORMAT,
		JPEG_2000_FORMAT
	}
	
	static public byte[] getBytesFromBitmap(Bitmap bitmap) {
	    ByteArrayOutputStream stream = new ByteArrayOutputStream();
	    bitmap.compress(CompressFormat.JPEG, 70, stream);
	    return Base64.encode(stream.toByteArray(), Base64.NO_WRAP);
	}
	
	static public Bitmap getBitmapFromBytes(byte[] encodedImage, ImageFormat format) throws IOException{
		byte[] base64Bytes = Base64.decode(encodedImage, Base64.DEFAULT);
		Bitmap decodedBytes = null;
		
		switch(format) {
		
		case JPEG_2000_FORMAT:
			decodedBytes = JJ2000Frontend.decode(encodedImage);       
			break;
			
		case PNG_FORMAT:
			decodedBytes = BitmapFactory.decodeByteArray(base64Bytes, 0, base64Bytes.length);
		case JPEG_FORMAT:
			decodedBytes = BitmapFactory.decodeByteArray(base64Bytes, 0, base64Bytes.length);
			break;
			
		default:
			decodedBytes = BitmapFactory.decodeByteArray(base64Bytes, 0, base64Bytes.length);
			break;
		}
		
		 
		
		return decodedBytes;
	}
}
