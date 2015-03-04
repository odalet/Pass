package com.sopra.passport;
import java.util.ArrayList;
import com.sopra.passport.data.Blob;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;


/**
 * Class implement the search listener functionality
 * it's used in the personListActivity for binding the 
 * text field to the person information
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class GalleryActivity extends Activity {

	
	
	private ArrayList<Blob> fingers;
	private int position = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_gallery);
		this.init();
		
	}
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.fingers = (ArrayList<Blob>) getIntent().getSerializableExtra("fingers");
		this.position = (int) getIntent().getIntExtra("position",position);
		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this,this.fingers,true,position);
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mCustomPagerAdapter);

	
	}
}
