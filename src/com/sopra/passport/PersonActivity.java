package com.sopra.passport;

import java.io.IOException;

import com.sopra.passport.data.Blob;
import com.sopra.passport.data.Person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This activity used to display selected user details.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class PersonActivity extends Activity {

	private Context mContext = this;
	private Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Person person = (Person) getIntent().getSerializableExtra("person");
        this.mPerson = person;
        initUI();
    }
    
    /**
	 * This method initializes the activity by person information.
     */
    private void initUI() {
    	TextView surnameView = (TextView)findViewById(R.id.person_surname_text);
        TextView givenNamesView = (TextView)findViewById(R.id.person_given_names_text);
        TextView nationalityView = (TextView)findViewById(R.id.person_nationality_text);
        TextView sexView = (TextView)findViewById(R.id.person_gender_text);
        TextView heightView = (TextView)findViewById(R.id.person_height_text);
        TextView eyesColorView = (TextView)findViewById(R.id.person_color_of_eyes_text);
        TextView birthdateView = (TextView)findViewById(R.id.person_birthdate_text);
        TextView birthplaceView = (TextView)findViewById(R.id.person_birthplace_text);
        TextView addressView = (TextView)findViewById(R.id.person_address_text);
        ImageView photoView = (ImageView)findViewById(R.id.person_photography_view);
        ImageView signatureView = (ImageView)findViewById(R.id.person_signature_view);
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this, mPerson.getFingerprints(), false, 0);
		ViewPager mViewPager = (ViewPager) findViewById(R.id.pagerViewer);
		
		mViewPager.setAdapter(mCustomPagerAdapter);
		mViewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin));    
        StringBuffer tmp;
        surnameView.setText(mPerson.getSurname());
        
        // Given names
        tmp = new StringBuffer();
        for (int i = 0; i < mPerson.getGivenNames().size() - 1; ++i) {
        	tmp.append(mPerson.getGivenNames().get(i));
        	tmp.append(", ");
        }
        
        tmp.append(mPerson.getGivenNames().get(mPerson.getGivenNames().size() - 1));
        givenNamesView.setText(tmp.toString());
        
        nationalityView.setText(mPerson.getNationality().getCountrName());
        sexView.setText(mPerson.getSex().toString());
        birthdateView.setText(mPerson.getBirthdate().toString());
        addressView.setText(mPerson.getAddress());
        birthplaceView.setText(mPerson.getBirthplace());
        eyesColorView.setText(mPerson.getEyesColor());
        heightView.setText(String.valueOf(mPerson.getHeight()));
        
        try {
			photoView.setImageBitmap(mPerson.getPhotoToBitmap());
			photoView.setOnClickListener(new ZoomListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
        	signatureView.setImageBitmap(mPerson.getSignatureToBitmap());
        	signatureView.setOnClickListener(new ZoomListener());
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    private class ZoomListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			ImageView currentView   = (ImageView) v;
			ImageView photoView 	= (ImageView)findViewById(R.id.person_photography_view);
	        ImageView signatureView = (ImageView)findViewById(R.id.person_signature_view);
			Blob img = null;	
		
			if (currentView == photoView)
				img = mPerson.getPhoto();
			else if (currentView == signatureView)
				img = mPerson.getSignature();
			
			Intent intent = new Intent(mContext, ImageActivity.class);
			intent.putExtra("image", img);
			startActivity(intent);
		}
    }
}
