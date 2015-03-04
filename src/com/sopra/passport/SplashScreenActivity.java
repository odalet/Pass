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
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class SplashScreenActivity extends Activity {

	private final Context context = this;
	private PersonDbHelper mpersonDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		mpersonDbHelper = new PersonDbHelper(context);
		if(ConnectionTools.isOnline(context))
		{
			new LoadingDataTask().execute();
		}
		else{
			if(mpersonDbHelper.checkDataBase(context)){
				PersonFactory.setPersons(mpersonDbHelper.getAllPersons());
				openMainActivity();
			}
		}
	}
	void openMainActivity(){
		Intent intent = new Intent(context, PersonListActivity.class);
		startActivity(intent);
		finish();
	}
	private class LoadingDataTask extends AsyncTask<Void, Void, Void> {
		protected void onPostExecute(Void v) {
			
			try {
				mpersonDbHelper.UpdateAll(PersonFactory.getListPersons());
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
