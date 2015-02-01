package com.sopra.passport;

import com.sopra.passport.data.CountryCode;
import com.sopra.passport.data.Gender;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


public class AdvancedSearch extends Activity {

	public static String PUBLIC_STATIC_STRING_IDENTIFIER;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advanced_search);
		
		final Spinner countries = (Spinner) findViewById(R.id.search_country);
		final Spinner gender	 =  (Spinner) findViewById(R.id.search_sex);
		Button searchbtn = (Button) findViewById(R.id.btnSearch);
		final TextView firstName = (TextView) findViewById(R.id.search_firstName);
		final TextView givenName = (TextView) findViewById(R.id.search_givenName);
		
		countries.setAdapter(new ArrayAdapter<CountryCode>(this,android.R.layout.simple_spinner_dropdown_item,CountryCode.values()));
		gender.setAdapter(new ArrayAdapter<Gender>(this,android.R.layout.simple_spinner_dropdown_item,Gender.values()));
	
		searchbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String namefirst = firstName.getText().toString();
                String namegiven = givenName.getText().toString();
                Gender selectedGender = (Gender)gender.getSelectedItem();
                CountryCode selectedCountryCode = (CountryCode)countries.getSelectedItem();
                
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", 10);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

		
	
	}
}
