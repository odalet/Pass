package com.sopra.passport;

import java.util.List;

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
import android.widget.EditText;
import android.widget.ListView;

public class PersonListActivity extends Activity {

	private Context context = this;
	static private List<Person> personList = null;
	private ListView personListView = null;
	
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
			Person selectedPerson = (Person) parent.getItemAtPosition(position);
		
			// Start PersonActivity
			Intent intent = new Intent(context, PersonActivity.class);
			intent.putExtra("person", selectedPerson);
			startActivity(intent);
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
}