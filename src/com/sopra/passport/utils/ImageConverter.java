package com.sopra.passport.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import jj2000.JJ2000Frontend;

import org.jnbis.WsqDecoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;

public class ImageConverter {

	public static enum ImageFormat {
		PNG_FORMAT,
		JPEG_FORMAT,
		JPEG_2000_FORMAT,
		WSQ_FORMAT
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
			decodedBytes = JJ2000Frontend.decode(base64Bytes);   
			break;
			
		case WSQ_FORMAT:
			WsqDecoder wsqDecoder = new WsqDecoder();
			decodedBytes = toAndroidBitmap(wsqDecoder.decode(base64Bytes));
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
	
	private static Bitmap toAndroidBitmap(org.jnbis.Bitmap bitmap) {
		byte[] byteData = bitmap.getPixels();
		int[] intData = new int[byteData.length];
		
		for (int j = 0; j < byteData.length; j++)
			intData[j] = 0xFF000000 | ((byteData[j] & 0xFF) << 16) | ((byteData[j] & 0xFF) << 8) | (byteData[j] & 0xFF);

		return Bitmap.createBitmap(intData, 0, bitmap.getWidth(), bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
	}
}
