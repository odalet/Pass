package com.sopra.passport;

import com.sopra.passport.utils.ConnexionTools;
import com.sopra.passport.utils.PersonDbHelper;
import com.sopra.passport.utils.PersonFactory;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;



public class SplashScreen extends Activity {

	private final Context context = this;
	private PersonDbHelper mpersonDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		new LoadingDataTask().execute();
	}

	
	
	private class LoadingDataTask extends AsyncTask<Void, Void, Void> {
		protected void onPostExecute(Void v) {
			Intent intent = new Intent(context, PersonListActivity.class);
			startActivity(intent);
			finish();
    	}
		@Override
		protected Void doInBackground(Void... params) {	
			if(ConnexionTools.isOnline(context)){
				try {
					PersonFactory.getListPersonsFromWs();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				if(mpersonDbHelper.checkDataBase(context)){
					PersonFactory.setPerson(mpersonDbHelper.getAllPersons());
				}
			}
		
			return null;
		}
		
	}
	
	
	

}
