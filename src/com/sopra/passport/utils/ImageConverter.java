package com.sopra.passport.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import jj2000.JJ2000Frontend;

import org.jnbis.WsqDecoder;

import com.sopra.passport.data.Blob;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;

public class ImageConverter {
	
	public static byte[] getBytesFromBitmap(Bitmap bitmap) {
	    ByteArrayOutputStream stream = new ByteArrayOutputStream();
	    bitmap.compress(CompressFormat.JPEG, 70, stream);
	    return Base64.encode(stream.toByteArray(), Base64.NO_WRAP);
	}
	
	public static Bitmap getBitmapFromJPEG2000Bytes(byte[] encodedImage) throws IOException {
		byte[] base64Bytes = Base64.decode(encodedImage, Base64.DEFAULT);
		return JJ2000Frontend.decode(base64Bytes);
	}
	
	public static Bitmap getBitmapFromWSQBytes(byte[] encodedImage) throws IOException {
		byte[] base64Bytes = Base64.decode(encodedImage, Base64.DEFAULT);
		WsqDecoder wsqDecoder = new WsqDecoder();
		return toAndroidBitmap(wsqDecoder.decode(base64Bytes));
	}
	
	public static  Bitmap getBitmapFromBytes(byte[] encodedImage) throws IOException {
		try{
			byte[] base64Bytes = Base64.decode(encodedImage, Base64.DEFAULT);
			return BitmapFactory.decodeByteArray(base64Bytes,  0, base64Bytes.length);
		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
		return null;
		
	}
		
	private static Bitmap toAndroidBitmap(org.jnbis.Bitmap bitmap) {
		byte[] byteData = bitmap.getPixels();
		int[] intData = new int[byteData.length];
		
		for (int j = 0; j < byteData.length; j++)
			intData[j] = 0xFF000000 | ((byteData[j] & 0xFF) << 16) | ((byteData[j] & 0xFF) << 8) | (byteData[j] & 0xFF);

		return Bitmap.createBitmap(intData, 0, bitmap.getWidth(), bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBitmap(Blob inBlob) throws IOException{
		if (inBlob.getMimeType().equals("image/jpeg")) {
			
			return (T) ImageConverter.getBitmapFromBytes(inBlob.getData().getBytes());
			
		} else if (inBlob.getMimeType().equals("image/x-wsq")){
			
			return (T) ImageConverter.getBitmapFromWSQBytes(inBlob.getData().getBytes());
			
		} else if (inBlob.getMimeType().equals("image/jp2")){
			
			return (T) ImageConverter.getBitmapFromJPEG2000Bytes(inBlob.getData().getBytes());

		}
		
		return null;
		
	}
	
	
}
