package com.sopra.passport;

import java.util.ArrayList;

import com.sopra.passport.data.Blob;
import com.sopra.passport.data.Person;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;


public class ShowGallery extends Activity {

	private ArrayList<Blob> fingers;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_gallery);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.fingers = (ArrayList<Blob>) getIntent().getSerializableExtra("fingers");
		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this,this.fingers);
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mCustomPagerAdapter);
		
		
	}
}
