package com.sopra.passport;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sopra.passport.data.Person;
import com.sopra.passport.utils.PersonDbHelper;
import com.sopra.passport.utils.PersonFactory;

public class PersonListActivity extends Activity {

	private static final int STATIC_INTEGER_VALUE = 0x7f040001;
	private Context context = this;
	private List<Person> personList = null;
	public int returnValue = 0;
	private ListView personListView = null;
	private Person personSelected = null;
	private PersonDbHelper mpersonDbHelper;
	private PersonListAdapter mlistPersonAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_list);
		 mpersonDbHelper = new PersonDbHelper(context);
		 reloadPersonList();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		switch (id) {
		case R.id.action_settings:
			
			break;
		case R.id.action_refresh:
			loadPersonList();
			break;
		case R.id.action_search:
			Intent intent = new Intent(context, AdvancedSearch.class);	
			startActivityForResult(intent,STATIC_INTEGER_VALUE);
			break;

		default:
			break;
		}
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private void initUI() {
		personListView = (ListView) findViewById(R.id.list_personlist_view);
		mlistPersonAdapter = new PersonListAdapter(context, R.layout.person_item_row, personList);
		personListView.setAdapter(mlistPersonAdapter);
		personListView.setOnItemClickListener(new ItemClickListener());
		
		EditText inputSearch = (EditText) findViewById(R.id.list_search_text);
		inputSearch.addTextChangedListener(new SearchListener(this, personList, personListView));
		/*
		Button search = (Button) findViewById(R.id.searchbtn);
		search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(context, AdvancedSearch.class);	
    			startActivityForResult(intent,STATIC_INTEGER_VALUE);
            }
        });
        */

	}
	
	private void loadPersonList(){
		if(isOnline()){
			new PersonListGetTask().execute();
		}else{
    		if(mpersonDbHelper.checkDataBase(context)){
    			this.personList = mpersonDbHelper.getAllPersons();
    			initUI();			
    		}
		}
	}
	
	private void reloadPersonList(){
		if(isOnline()){
			new PersonListGetTask().execute();
		}else{
    		if(mpersonDbHelper.checkDataBase(context)){
    			this.personList = mpersonDbHelper.getAllPersons();
    			initUI();			
    		}
		}
	}
	
	
	private class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// this part is an obligation for using the http request in the main thread
			new PersonGetByIdTask().execute();
			
		}
	}
	
	private class PersonGetByIdTask extends AsyncTask<Void, Void, Void>{

    	@Override
    	protected void onPostExecute(Void v) {
    		Intent intent = new Intent(context, PersonActivity.class);
			intent.putExtra("person", personSelected);		
			startActivity(intent);
    	}
		
		@Override
		protected Void doInBackground(Void... params) {
			personSelected = PersonFactory.getUserById();	
			return null;
		}
		
	}
	
	
	private class PersonListGetTask extends AsyncTask<Void, Void, Void> {
    	
    	@Override
    	protected void onPostExecute(Void v) {
    		try{
				mpersonDbHelper.UpdateAll(personList);
			}catch(Exception exp){
				exp.printStackTrace();
			}
    		initUI();
    	}

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				personList = PersonFactory.getListPersons();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
    		return null;
		}
    }
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
	  super.onActivityResult(requestCode, resultCode, data); 
	  switch(requestCode) { 
	    case (STATIC_INTEGER_VALUE) : 
		    // on returning from search part this block will be executed
	    	if (resultCode == Activity.RESULT_OK) { 
	    		PersonFilter searchElement = (PersonFilter)data.getSerializableExtra("searchCriteria");
	    		rechargeList(searchElement);
	    	} 
	      break; 
	    } 
	  } 
	
	
	private boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    return netInfo != null && netInfo.isConnectedOrConnecting();
	}
	
	private void rechargeList(PersonFilter searchElement){
		List<Person> listPerson = new ArrayList<Person>();
		for(Person person : this.personList){
			if(person.filter(searchElement)){
				listPerson.add(person);
			}
		}
		
		if(listPerson.size() != 0){
			this.personList = listPerson;
			initUI();
		}
		
	}
	
	
	
	
}
