package com.sopra.passport.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sopra.passport.data.Person;

public class PersonDbHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1; 
	private static final String TABLE_NAME = "Person";
    private static final String DATABASE_NAME = "_B_Person.db"; 
	private static final String COLUMN_NAME_ID = "_ID";
    private static final String COLUMN_NAME_OBJECT = "_PERSON";
 	private static final String[] COLONNES = { COLUMN_NAME_ID, COLUMN_NAME_OBJECT}; 

    private static final String CREATE_BDD = "CREATE TABLE  " + TABLE_NAME + " ("
    			+ COLUMN_NAME_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_OBJECT + " BLOB NOT NULL);";
     
 	public PersonDbHelper(Context context) {
 		super(context, DATABASE_NAME, null, DATABASE_VERSION);

 		} 
     
	public PersonDbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BDD);
		Log.i("creation DataBase", "Base de données crée");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(CREATE_BDD);
        onCreate(db);
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		super.onDowngrade(db, oldVersion, newVersion);
	}
	
	public void addOne(Person person) throws IOException {	 
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME_ID, person.getId());
		values.put(COLUMN_NAME_OBJECT,Person.serialize(person));	// insertion
		db.insert(TABLE_NAME,null, values);
		db.close();
	}
	
	public void AddListPersons(List<Person> persons) throws IOException{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = null;
		for(Person person : persons){
			values = new ContentValues();
			values.put(COLUMN_NAME_ID, person.getId());
			values.put(COLUMN_NAME_OBJECT,Person.serialize(person));	// insertion
			db.insert(TABLE_NAME,null, values);
		}
		db.close();
	}
	
	public List<Person> getAllPersons(){
		List<Person> listPersons = new ArrayList<Person>(); 
		String query = "SELECT  * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query,null);
		Person person = null;
		if (cursor.moveToFirst()) {
			do {
				person = new Person();
				byte[] bperson = cursor.getBlob(cursor.getColumnIndex(COLUMN_NAME_OBJECT));
				try {
					person = Person.deserialise(bperson);
					listPersons.add(person);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (cursor.moveToNext());
		} 
		return listPersons;
	}
	
	public void Remove(Person person){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, "_ID = ?", new String[] { String.valueOf(person.getId()) });
		db.close(); 
	}
	
	public boolean checkDataBase(Context context){
		try{
			File database=context.getDatabasePath(DATABASE_NAME);

			if (!database.exists()) {
			    return false;
			} else {
			    return true;
			}
		}catch(Exception exp){
			
		}
		return false;
		
	}
	
	
	public Person getPersonById(int id){
		Person person = null;
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, 
				COLONNES,
				" _ID = ?",
				new String[] { String.valueOf(id) }, // d. selections args
				null,
				null,
				null,
				null);
		
		if(cursor != null){
			if(cursor.moveToFirst()){
				byte[] data = cursor.getBlob(cursor.getColumnIndex(COLUMN_NAME_OBJECT));
				try {
					person = Person.deserialise(data);
					return person;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}else
			{
				System.out.println("");
			}
			
		}
		return person;
	}
	
	public void UpdateAll(List<Person> listPersons) throws IOException{
		//using rawQuery should work, but can be a potential security risk
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, null, null);
		db.close();
		AddListPersons(listPersons);
	}
	
	
}
