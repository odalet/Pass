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
import com.sopra.passport.utils.ConnectionTools;
import com.sopra.passport.utils.PersonDbHelper;
import com.sopra.passport.utils.PersonFactory;

/**
 * This class is the main activity of the application.
 * contains a the charged list of persons
 * it's the  heart of the application
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */

public class PersonListActivity extends Activity {

	private static final int STATIC_INTEGER_VALUE = 0x7f040001;
	
	private Context mContext = this;
	private List<Person> mPersonList = null;
	public int mReturnValue = 0;
	private ListView mPersonListView = null;
	private Person mPersonSelected = null;
	private PersonDbHelper mPersonDbHelper;
	private PersonListAdapter mListPersonAdapter;
	private ProgressDialog mBarProgressDialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_list);
		mPersonDbHelper = new PersonDbHelper(mContext);
		mPersonList = PersonFactory.getListPersons();
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
			Intent intent = new Intent(mContext, AdvancedSearchActivity.class);	
			startActivityForResult(intent,STATIC_INTEGER_VALUE);
			break;
		default:
			break;
		}
		
		if (id == R.id.action_settings)
			return true;
		
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Initialization method.
	 */
	private void initUI() {
		mPersonListView = (ListView) findViewById(R.id.list_personlist_view);
		notifyListView();
		mBarProgressDialog = new ProgressDialog(PersonListActivity.this);
		mBarProgressDialog.setTitle("Loading.....");
		mBarProgressDialog.setMessage("Please wait ");
		EditText inputSearch = (EditText) findViewById(R.id.list_search_text);
		inputSearch.addTextChangedListener(new SearchListener(this, mPersonList, mPersonListView));
	}
	
	/**
	 * Method used to refresh person list content. 
	 * @return void
	 */
	private void notifyListView(){
		mListPersonAdapter = new PersonListAdapter(mContext, R.layout.person_item_row, mPersonList);
		mPersonListView.setAdapter(mListPersonAdapter);
		mPersonListView.setOnItemClickListener(new ItemClickListener());
	}
	
	private void loadPersonList(){
		if(ConnectionTools.isOnline(mContext)){
			    mBarProgressDialog.show();
			new GetPersonListTask().execute();
		} else {
    		if(mPersonDbHelper.checkDataBase(mContext)){
    			this.mPersonList = mPersonDbHelper.getAllPersons();
    			initUI();			
    		}
		}
	}
	
	/**
	 * This class implements OnItemClickListener interface.
	 * It's used to load person details from :
	 *  	- web service : if the person is not recently charged and the device is connected
	 *  	- database : there is no connection and person charged in the database
	 *		- from the initial list : if there is no person and no connection
	 */
	private class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if(!mPersonList.get(position).isCharged && ConnectionTools.isOnline(mContext)) {
				Integer[] pos = new Integer[]{position};
				new GetPersonByIdTask().execute(pos);
			} else if(ConnectionTools.isOnline(mContext) || mPersonList.get(position).isCharged) {
				openPersonDetails(mPersonList.get(position));
			} else {
				Person selected = mPersonList.get(position);
				Intent intent = new Intent(mContext, PersonCardActivity.class);	
				intent.putExtra("person", selected);
				startActivity(intent);
			}
		}
	}
	
	private void openPersonDetails(Person inPerson){
		Intent intent = new Intent(mContext, PersonActivity.class);
		intent.putExtra("person", inPerson);		
		startActivity(intent);
	}
	
	private class GetPersonByIdTask extends AsyncTask<Integer, Void, Void>{
		public GetPersonByIdTask(){
			super();
		}
    	
		@Override
    	protected void onPostExecute(Void v) {
    		openPersonDetails(mPersonSelected);
    		changeStateListView();
    		notifyListView();
    	}
	
    	/**
    	 * This function lunch a thread in background as a worker for 
    	 * after loading person, and update the person in database.
    	 */
		@Override
		protected Void doInBackground(Integer... params) {
			changeStateListView();
			int position = params[0];
			mPersonSelected = PersonFactory.getPersonById(mPersonList.get(position).getId());
			mPersonList.set(position,Person.combine(mPersonSelected,mPersonList.get(position)));
			
			try {
				mPersonDbHelper.update(mPersonSelected);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
	/**
	 * This class is used to loading the person list from WS.
	 * Used as an asynchronous task, it's called when the device is connection to Internet
	 */
	private class GetPersonListTask extends AsyncTask<Void, Void, Void> {
    	
    	@Override
    	protected void onPostExecute(Void v) {
    		try{
				mPersonDbHelper.updateAll(mPersonList);
			} catch(Exception exp){
				exp.printStackTrace();
			}
    		
    		mBarProgressDialog.hide();
    		initUI();
    	}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				mPersonList = PersonFactory.getListPersonsFromWs();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
    		return null;
		}
    }
	
	/**
	 * This method is called for filtering persons by criteria.
	 * Used in the advanced search activity.
	 */
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
	  super.onActivityResult(requestCode, resultCode, data); 
	  switch(requestCode) { 
	    case (STATIC_INTEGER_VALUE) : 
		    // on returning from search part this block will be executed
	    	if (resultCode == Activity.RESULT_OK) { 
	    		PersonFilter searchElement = (PersonFilter)data.getSerializableExtra("searchCriteria");
	    		reloadList(searchElement);
	    	} 
	      break; 
	    } 
	  } 
	
	private void reloadList(PersonFilter searchElement) {
		List<Person> listPerson = new ArrayList<Person>();
		
		for(Person person : this.mPersonList){
			if(person.filter(searchElement)){
				listPerson.add(person);
			}
		}
		
		if(listPerson.size() != 0){
			this.mPersonList = listPerson;
			initUI();
		}
	}
	
	void changeStateListView() {
		runOnUiThread(new Runnable() {
			public void run() {
				if(mPersonListView.isEnabled()) {
					mPersonListView.setEnabled(false);
					mBarProgressDialog.show();
				} else {
					mBarProgressDialog.hide();
					mPersonListView.setEnabled(true);
				}	
			}
		});
	}
}
