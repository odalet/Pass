package com.sopra.passport;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;

import com.sopra.passport.data.User;

public class SearchListener implements TextWatcher {

	private Context context;
	private List<User> userList;
	private ListView userListView;
	
	public SearchListener(Context context, List<User> userList, ListView userListView) {
		this.context = context;
		this.userList = userList;
		this.userListView = userListView;
	}
	
	public boolean search(CharSequence s, User user) {
		boolean result = false;
		
		if (user.getSurname().toLowerCase(Locale.ENGLISH).contains(s.toString().toLowerCase(Locale.ENGLISH)))
			result = true;
		
		for (String name : user.getGivenNames()) {
			if (name.toLowerCase(Locale.ENGLISH).contains(s.toString().toLowerCase(Locale.ENGLISH)))
				result = true;
		}
		
		return result;
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		List<User> tmpList = new ArrayList<User>();
		UserListAdapter userListAdapter = null;
		
		for (User user : userList) {
			if (search(s, user))
				tmpList.add(user);
		}
		
		userListAdapter = new UserListAdapter(context, R.layout.user_item_row, tmpList);
		userListView.setAdapter(userListAdapter);
	}

	@Override
	public void afterTextChanged(Editable s) {

	}
}