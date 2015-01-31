package com.sopra.passport;

import java.io.IOException;

import com.sopra.passport.data.Person;
import com.sopra.passport.utils.PersonFactory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends Activity {

	private Context context = this;
	private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Person person = (Person) getIntent().getSerializableExtra("person");
        this.person = person;
        initUI();
    }
    
    private void initUI()  {
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
        ImageView fingerprintView = (ImageView)findViewById(R.id.person_fingerprint_view);
        StringBuffer tmp;
        
        
        surnameView.setText(person.getSurname());
        

        
        // Given names
        tmp = new StringBuffer();
        for (int i = 0; i < person.getGivenNames().size() - 1; ++i) {
        	tmp.append(person.getGivenNames().get(i));
        	tmp.append(", ");
        }
        
        tmp.append(person.getGivenNames().get(person.getGivenNames().size() - 1));
        givenNamesView.setText(tmp.toString());
        
        nationalityView.setText(person.getNationality());
        sexView.setText(person.getSex().toString());
        birthdateView.setText(person.getBirthdate().toString());
        addressView.setText(person.getAddress());
   
        try {
			photoView.setImageBitmap(person.getPhotoToBitmap());
			photoView.setOnClickListener(new ZoomListener());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
        	signatureView.setImageBitmap(person.getSignatureToBitmap());
        	signatureView.setOnClickListener(new ZoomListener());
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
		
        
        /*
        // Height
        tmp = new StringBuffer();
        tmp.append(Math.round(person.getHeight() * 100.) / 100.);
        tmp.append(" ");
        tmp.append(getString(R.string.height_unit_text));
        heightView.setText(tmp.toString());
        
        eyesColorView.setText(person.getEyesColor().toString());
        
        birthplaceView.setText(person.getBirthplace());
        

        
        
        try {
        	signatureView.setImageBitmap(person.getSignatureToBitmap());
        	signatureView.setOnClickListener(new ZoomListener());
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        */
        /*
        try {
        	fingerprintView.setImageBitmap(person.getFingerprintToBitmap());
        	fingerprintView.setOnClickListener(new ZoomListener());
        } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        */
    }
    
    private class ZoomListener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			ImageView currentView = (ImageView) v;
			ImageView photoView = (ImageView)findViewById(R.id.person_photography_view);
	        ImageView signatureView = (ImageView)findViewById(R.id.person_signature_view);
	        ImageView fingerprintView = (ImageView)findViewById(R.id.person_fingerprint_view);
			byte[] img = null;
			
			if (currentView == photoView)
				img = person.getPhoto().getData().getBytes();
			else if (currentView == signatureView)
				img = person.getSignature().getData().getBytes();
			else if (currentView == fingerprintView){
				
			}
				//img = person.getFingerprint();
			
			Intent intent = new Intent(context, ImageActivity.class);
			intent.putExtra("image", img);
			startActivity(intent);
		}
    }
}
