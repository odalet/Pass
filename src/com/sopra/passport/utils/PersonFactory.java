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


public class PersonFactory {

	private static final String WS_URL = "http://deltaapps.apphb.com/siti/persons/";
	
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
        HttpGet myConnection = new HttpGet(WS_URL);
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
        HttpGet myConnection = new HttpGet(WS_URL + Integer.toString(1));
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
			e.printStackTrace();
		} 
		return person;
	}
}
