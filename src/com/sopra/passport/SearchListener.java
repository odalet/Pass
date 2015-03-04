package com.sopra.passport;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;

import com.sopra.passport.data.Person;



/**
 * Class implement the search listener functionality
 * it's used in the personListActivity for binding the 
 * text field to the person information
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */

public class SearchListener implements TextWatcher {

	private Context context;
	private List<Person> personList;
	private ListView personListView;
	
	public SearchListener(Context context, List<Person> personList, ListView personListView) {
		this.context = context;
		this.personList = personList;
		this.personListView = personListView;
	}
	
	public boolean search(CharSequence s, Person person) {
		boolean result = false;
		
		if (person.getSurname().toLowerCase(Locale.ENGLISH).contains(s.toString().toLowerCase(Locale.ENGLISH)))
			result = true;
		
		for (String name : person.getGivenNames()) {
			if (name.toLowerCase(Locale.ENGLISH).contains(s.toString().toLowerCase(Locale.ENGLISH)))
				result = true;
		}
		
		return result;
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		
	}

	/**
	 * if the text is changed we detected, if there is a new value
	 * and after that we search the person having the inserted value.
	 */
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		List<Person> tmpList = new ArrayList<Person>();
		PersonListAdapter personListAdapter = null;
		
		for (Person person : personList) {
			if (search(s, person))
				tmpList.add(person);
		}
		
		personListAdapter = new PersonListAdapter(context, R.layout.person_item_row, tmpList);
		personListView.setAdapter(personListAdapter);
	}

	@Override
	public void afterTextChanged(Editable s) {

	}
}