package com.sopra.passport.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;

import com.sopra.passport.data.Person;

/**
 * This function executes HTTP requests
 * for getting a person list from web service
 * it's implemented factory and singleton patterns
 *
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 *
 */
@SuppressWarnings("unused")
public class PersonFactory {
	/**
	 * Web service url
	 */
	private static final String WS_URL = "http://deltaapps.apphb.com/siti/persons/";
	private static List<Person> mListPerson;
	private static PersonFactory mPersonFactory;
	
	private PersonFactory(){
		try{
			JSONArray hs = new JSONArray(getJsonArray());
			ObjectMapper mapper = new ObjectMapper();
			List<PersonModel> userListModels = null;
			List<Person> userList = null;
			
			userListModels = mapper.readValue(
				hs.toString(), 
				new TypeReference<List<PersonModel>>(){}
			);
			
			userList = new ArrayList<Person>();
			for (PersonModel userModel : userListModels) {
				userList.add(userModel.toUser());
			}
			mListPerson = userList;
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
	
	/**
	 * pattern sigleton implementation
	 * 
	 * @return List<Person>
	 * @param void
	 */
	static public synchronized List<Person> getListPersons(){
		if(mListPerson == null){
			mPersonFactory = new PersonFactory();
		}
		return mListPerson;
	}
	/**
	 * @return List<Person>
	 * @param void
	 */
	static public List<Person> getListPersonsFromWs(){
		mPersonFactory = new PersonFactory();
		return mListPerson;
	}
	
	/**
	 * 
	 * @return String
	 * @throws JSONException
	 */
	private static String getJsonArray() throws JSONException {
		String str = null;
		try {
		HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpGet myConnection = new HttpGet(WS_URL);
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }
	
	/**
	 * 
	 * @param id
	 * @return String
	 */
	private static String getJsonPerson(int id){
		String str = null;
		HttpResponse response;
		try {
        HttpClient myClient = new DefaultHttpClient();
        HttpGet myConnection = new HttpGet(WS_URL + Integer.toString(id));
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return str;
	}
	
	/**
	 * 
	 * @param id
	 * @return Person
	 */
	public static Person getPersonById(int id){
		Person person = null;
		ObjectMapper mapper = new ObjectMapper();
		PersonModel modelPerson;
		try {
			modelPerson = mapper.readValue(getJsonPerson(id), PersonModel.class);
			person = modelPerson.toUser();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return person;
	}

	/**
	 * 
	 * @param listPerson
	 */
	public static void setPersons(List<Person> listPerson){
		mListPerson = listPerson;
	}
}
