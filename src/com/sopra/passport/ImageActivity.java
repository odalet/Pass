package com.sopra.passport;

import java.io.IOException;

import com.sopra.passport.data.Blob;
import com.sopra.passport.utils.ImageConverter;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * The rule of This activity is to display 
 * a picture in the backgound of the activity
 * and use the zoom functionalities
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class ImageActivity extends Activity {
	
	private Bitmap image;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_image);
		try {
			TouchImageView img = new TouchImageView(this);  
			Blob imgBlob = (Blob) getIntent().getSerializableExtra("image");
			this.image = ImageConverter.getBitmap(imgBlob);
			img.setImageBitmap(this.image); 
		    img.setMaxZoom(4f);  
		    setContentView(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	/**
	 * A placeholder fragment containing a simple view.
	 * it's used to display pictures as fragments
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_image, container, false);
			return rootView;
		}
	}
}
