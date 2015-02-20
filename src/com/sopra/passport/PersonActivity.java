package com.sopra.passport;

import java.io.IOException;

import com.sopra.passport.data.Blob;
import com.sopra.passport.data.Person;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
        Button showFingers = (Button)findViewById(R.id.showfingerprints);
        showFingers.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ShowGallery.class);
				intent.putExtra("fingers", person.getFingerprints());		
				startActivity(intent);
			}
		});
        
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
        
        nationalityView.setText(person.getNationality().getCountrName());
        sexView.setText(person.getSex().toString());
        birthdateView.setText(person.getBirthdate().toString());
        addressView.setText(person.getAddress());
        birthplaceView.setText(person.getBirthplace());
        eyesColorView.setText(person.getEyesColor());
        heightView.setText(String.valueOf(person.getHeight()));
        
        try {
			photoView.setImageBitmap(person.getPhotoToBitmap());
			photoView.setOnClickListener(new ZoomListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
        	signatureView.setImageBitmap(person.getSignatureToBitmap());
        	signatureView.setOnClickListener(new ZoomListener());
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    private class ZoomListener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			ImageView currentView = (ImageView) v;
			ImageView photoView = (ImageView)findViewById(R.id.person_photography_view);
	        ImageView signatureView = (ImageView)findViewById(R.id.person_signature_view);
			Blob img = null;	
			if (currentView == photoView){
				img = person.getPhoto();
			}
			else if (currentView == signatureView)
			{
				img = person.getSignature();
			}
			Intent intent = new Intent(context, ImageActivity.class);
			intent.putExtra("image", img);
			startActivity(intent);
		}
    }
    
}
