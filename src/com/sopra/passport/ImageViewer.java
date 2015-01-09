package com.sopra.passport;

import com.sopra.passport.utils.ImageConverter;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;



public class ImageViewer extends Activity {
	
	ZoomControls zoom;
	ImageView photoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_viewer);
    	byte [] myImg = (byte [])getIntent().getSerializableExtra("image");
    	final ImageView photoView = (ImageView)findViewById(R.id.imageViewer);
    	Bitmap myImgBitMap = ImageConverter.getBitmapFromBytes(myImg);
    	photoView.setImageBitmap(myImgBitMap);
    	
    	zoom = (ZoomControls) findViewById(R.id.zoomControls1);
    	
    	zoom.setOnZoomInClickListener(new OnClickListener() {
			
    		@Override
    		public void onClick(View v) {
    			float x = photoView.getScaleX();
    			float y = photoView.getScaleY();	
    			photoView.setScaleX((float) (x+1));
    			photoView.setScaleY((float) (y+1));
    		}
    	});
     
            zoom.setOnZoomOutClickListener(new View.OnClickListener() {
    			
    		@Override
    		public void onClick(View v) {
    			float x = photoView.getScaleX();
    			float y = photoView.getScaleY();
    			photoView.setScaleX((float) (x-1));
    			photoView.setScaleY((float) (y-1));
    		}
    	});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_viewer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.image_viewer, container,
					false);
			return rootView;
		}
	}
}
