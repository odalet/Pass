package com.sopra.passport;
import java.util.ArrayList;

import javax.annotation.Resource;

import com.sopra.passport.data.Blob;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

public class ShowGallery extends Activity {

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
