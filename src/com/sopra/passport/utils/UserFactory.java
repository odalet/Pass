package com.sopra.passport.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.sopra.passport.data.User;

public class UserFactory {

	private static final String FILE_URL = "http://madridi2.olympe.in/Users.json"; 
	
	static public List<User> getListUsers() throws JSONException, 
												   JsonParseException,
												   JsonMappingException, 
												   IOException {
		JSONArray hs = new JSONArray(getJsonArray());
		ObjectMapper mapper = new ObjectMapper();
		List<UserModel> userListModels = null;
		List<User> userList = null;
		
		userListModels = mapper.readValue(
			hs.toString(), 
			new TypeReference<List<UserModel>>(){}
		);
		
		userList = new ArrayList<User>();
		for (UserModel userModel : userListModels) {
			userList.add(userModel.toUser());
		}
		
		return userList;
	}	
	
	static private String getJsonArray() throws JSONException {
        HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost(FILE_URL);
        String str = null;

        try {
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return str;
    }
}
