package com.sopra.passport;

import com.sopra.passport.data.CountryCode;
import com.sopra.passport.data.Gender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
                
                PersonFilter serchBloc = new PersonFilter();
                serchBloc.setFirstName(namefirst);
                serchBloc.setGivenName(namegiven);
                serchBloc.setNationality(selectedCountryCode);
                serchBloc.setSex(selectedGender);
                
                Intent resultIntent = new Intent();
                resultIntent.putExtra("searchCriteria", serchBloc);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

		
	
	}
}
