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

/**
 * This class implements advanced search service in activity.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD
 */
public class AdvancedSearchActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advanced_search);
		
		final Spinner countries = (Spinner) findViewById(R.id.search_country);
		final Spinner gender = (Spinner) findViewById(R.id.search_sex);
		final TextView firstName = (TextView) findViewById(R.id.search_firstName);
		final TextView givenName = (TextView) findViewById(R.id.search_givenName);
		final Button searchButton = (Button) findViewById(R.id.btnSearch);
		
		countries.setAdapter(new ArrayAdapter<CountryCode>(this,android.R.layout.simple_spinner_dropdown_item,CountryCode.values()));
		gender.setAdapter(new ArrayAdapter<Gender>(this,android.R.layout.simple_spinner_dropdown_item,Gender.values()));
	
		searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nameFirst = firstName.getText().toString();
                String nameGiven = givenName.getText().toString();
                Gender selectedGender = (Gender)gender.getSelectedItem();
                CountryCode selectedCountryCode = (CountryCode)countries.getSelectedItem();
                
                PersonFilter serchBloc = new PersonFilter();
                serchBloc.setFirstName(nameFirst);
                serchBloc.setGivenName(nameGiven);
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
