package com.sopra.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.sopra.passport.utils.ConnectionTools;
import com.sopra.passport.utils.PersonDbHelper;
import com.sopra.passport.utils.PersonFactory;

/**
 * This class is the splash screen activity.
 * It's used to manage database access if there is no valid Internet connection.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class SplashScreenActivity extends Activity {

	private final Context mContext = this;
	private PersonDbHelper mPersonDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		mPersonDbHelper = new PersonDbHelper(mContext);
		
		if(ConnectionTools.isOnline(mContext))
			new LoadingDataTask().execute();
		else {
			if(mPersonDbHelper.checkDataBase(mContext)){
				PersonFactory.setPersons(mPersonDbHelper.getAllPersons());
				openMainActivity();
			}
		}
	}
	
	void openMainActivity(){
		Intent intent = new Intent(mContext, PersonListActivity.class);
		startActivity(intent);
		finish();
	}
	
	private class LoadingDataTask extends AsyncTask<Void, Void, Void> {
		
		protected void onPostExecute(Void v) {	
			try {
				mPersonDbHelper.updateAll(PersonFactory.getListPersons());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			openMainActivity();	
    	}
		
		@Override
		protected Void doInBackground(Void... params) {	
			PersonFactory.getListPersonsFromWs();
			return null;
		}
	}
}
