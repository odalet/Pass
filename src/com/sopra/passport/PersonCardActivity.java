package com.sopra.passport;

import java.io.IOException;

import com.sopra.passport.data.Person;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * If the person not charged from WS and there is no connection
 * this activity will display the person charged information.
 * It's used as pop up (see the manifest content for more informations).
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class PersonCardActivity extends Activity {

	private Person mPerson;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mPerson = (Person) getIntent().getSerializableExtra("person");

		requestWindowFeature(Window.FEATURE_NO_TITLE);     
		setContentView(R.layout.card_person);
		TextView surname = (TextView)findViewById(R.id.person_surname);
		
		TextView nationality = (TextView)findViewById(R.id.person_nationality);
		TextView birthDate = (TextView)findViewById(R.id.person_Birth);
		TextView height = (TextView)findViewById(R.id.person_height);
		TextView givenName = (TextView)findViewById(R.id.person_given_names);
		TextView eyesCol = (TextView)findViewById(R.id.person_EyesCol);
		ImageView profile = (ImageView)findViewById(R.id.person_short_photography);

		surname.setText(mPerson.getSurname());
		
		birthDate.setText(mPerson.getBirthdate().toString());
		nationality.setText(mPerson.getNationality().getAlpha3());
		height.setText(String.valueOf(mPerson.getHeight()));
		givenName.setText(mPerson.getGivenNames().get(0));
		eyesCol.setText(mPerson.getEyesColor());
		
		try {
			profile.setImageBitmap(mPerson.getPhotoToBitmap());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_carte, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
			return true;
		
		return super.onOptionsItemSelected(item);
	}
}
