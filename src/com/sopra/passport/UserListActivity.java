package com.sopra.passport;

import java.util.List;

import com.sopra.passport.data.User;
import com.sopra.passport.utils.UserFactory;

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

public class UserListActivity extends Activity {

	private Context context = this;
	static private List<User> userList = null;
	private ListView userListView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_list);
		
		new UserListGetTask().execute();
	}
	
	private void initUI() {
		userListView = (ListView) findViewById(R.id.list_userlist_view);
		userListView.setAdapter(new UserListAdapter(context, R.layout.user_item_row, userList));
		userListView.setOnItemClickListener(new ItemClickListener());
		
		EditText inputSearch = (EditText) findViewById(R.id.list_search_text);
		inputSearch.addTextChangedListener(new SearchListener(this, userList, userListView));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_list, menu);
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
			User selectedUser = (User) parent.getItemAtPosition(position);
		
			// Start UserActivity
			Intent intent = new Intent(context, UserActivity.class);
			intent.putExtra("user", selectedUser);
			startActivity(intent);
		}
	}
	
	
	
	private class UserListGetTask extends AsyncTask<Void, Void, Void> {
    	
    	@Override
    	protected void onPostExecute(Void v) {
    		initUI();
    	}

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				userList = UserFactory.getListUsers();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
    		return null;
		}
    }
}
