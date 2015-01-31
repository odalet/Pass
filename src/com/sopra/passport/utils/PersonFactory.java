package com.sopra.passport.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.sopra.passport.data.Person;

public class PersonFactory {

	private static final String FILE_URL = "http://madridi2.olympe.in/Users.json"; 
	private static final String USER_URL = "http://madridi2.olympe.in/person.json";
	
	static public List<Person> getListPersons() throws JSONException, 
												   	   JsonParseException,
												       JsonMappingException, 
												       IOException {
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
		
		return userList;
	}	
	
	private static String getJsonArray() throws JSONException {
		String str = null;
		try {
		HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost(FILE_URL);
        

        
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return str;
    }
	
	private static String getJsonUser(){
		String str = null;
		HttpResponse response;
		try {
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost(USER_URL);
        
        
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return str;
	}
	
	public static Person getUserById(){
		Person person = null;
		ObjectMapper mapper = new ObjectMapper();
		PersonModel modelPerson;
		try {
			modelPerson = mapper.readValue(getJsonUser(), PersonModel.class);
			person = modelPerson.toUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return person;
	}
}
