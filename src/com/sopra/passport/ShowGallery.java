package com.sopra.passport;

import java.util.ArrayList;

import com.sopra.passport.data.Blob;
import com.sopra.passport.data.Person;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;


public class ShowGallery extends Activity {

	private ArrayList<Blob> fingers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_gallery);
		
		this.fingers = (ArrayList<Blob>) getIntent().getSerializableExtra("fingers");
     
		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this,this.fingers);
		 
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mCustomPagerAdapter);
		
		
	}
}
