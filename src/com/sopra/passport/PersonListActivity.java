package com.sopra.passport;

import java.util.List;

import javax.jws.Oneway;

import com.sopra.passport.data.Person;
import com.sopra.passport.utils.PersonFactory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class PersonListActivity extends Activity {

	private static final int STATIC_INTEGER_VALUE = 0x7f040001;
	private Context context = this;
	static private List<Person> personList = null;
	public int returnValue = 0;
	private ListView personListView = null;
	private Person personSelected = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_list);
		
		new PersonListGetTask().execute();
	}

	

	
	private void initUI() {
		personListView = (ListView) findViewById(R.id.list_personlist_view);
		personListView.setAdapter(new PersonListAdapter(context, R.layout.person_item_row, personList));
		personListView.setOnItemClickListener(new ItemClickListener());
		
		EditText inputSearch = (EditText) findViewById(R.id.list_search_text);
		inputSearch.addTextChangedListener(new SearchListener(this, personList, personListView));
		
		Button search = (Button) findViewById(R.id.searchbtn);
		search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(context, AdvancedSearch.class);	
    			startActivityForResult(intent,STATIC_INTEGER_VALUE);
            }
        });

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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			//Person selectedPerson = (Person) parent.getItemAtPosition(position);
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
			 //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	         //getApplicationContext().startActivity(intent);
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
	    	
	    	if (resultCode == Activity.RESULT_OK) { 
	    	      //int tabIndex = (int)data.getSerializableExtra("val");
	    	      // TODO Switch tabs using the index.
	    	} 
	    
	      // on returning from search part this block will be executed
	      break; 
	    } 
	  } 
	
	
	
	
}
