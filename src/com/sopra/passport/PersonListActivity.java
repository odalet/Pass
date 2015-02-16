package com.sopra.passport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.sopra.passport.data.Person;
import com.sopra.passport.utils.ConnexionTools;
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
	private ProgressDialog barProgressDialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_list);
		 mpersonDbHelper = new PersonDbHelper(context);
		 personList = PersonFactory.getListPersons();
		 initUI();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.person_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
		notifyListView();
		barProgressDialog = new ProgressDialog(PersonListActivity.this);
		barProgressDialog.setTitle("Loading.....");

		EditText inputSearch = (EditText) findViewById(R.id.list_search_text);
		inputSearch.addTextChangedListener(new SearchListener(this, personList, personListView));
	}
	
	private void notifyListView(){
		mlistPersonAdapter = new PersonListAdapter(context, R.layout.person_item_row, personList);
		personListView.setAdapter(mlistPersonAdapter);
		personListView.setOnItemClickListener(new ItemClickListener());
	}
	
	private void loadPersonList(){
		if(ConnexionTools.isOnline(context)){
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
			//Integer[] integer = new Integer[]{personList.get(position).getId()};
			if(!personList.get(position).isCharged){
				Integer[] pos = new Integer[]{position};
				new getPersonByIdTask().execute(pos);
			}else{
				openPersonDetails(personList.get(position));
			}
		}
	}
	
	private void openPersonDetails(Person inPerson){
		Intent intent = new Intent(context, PersonActivity.class);
		intent.putExtra("person", inPerson);		
		startActivity(intent);
	}
	
	private class getPersonByIdTask extends AsyncTask<Integer, Void, Void>{
		
		
		public getPersonByIdTask(){
			super();

		}
		
    	@Override
    	protected void onPostExecute(Void v) {
    		openPersonDetails(personSelected);
    		ChangeStateListView();
    		notifyListView();
    	}
		
		@Override
		protected Void doInBackground(Integer... params) {
			ChangeStateListView();
			int position = params[0];
			personSelected = PersonFactory.getPersonById(personList.get(position).getId());
			personList.set(position,Person.combine(personSelected,personList.get(position)));
			try {
				mpersonDbHelper.update(personSelected);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
	void ChangeStateListView(){
		runOnUiThread(new Runnable() {
			public void run() {
				if(personListView.isEnabled()){
					personListView.setEnabled(false);
					barProgressDialog.show();
				}else{
					barProgressDialog.hide();
					personListView.setEnabled(true);
				}	
			}
		});
	}
	
	
	
	
}
