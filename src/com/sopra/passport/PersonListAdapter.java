package com.sopra.passport;
import java.io.IOException;
import java.util.List;

import com.sopra.passport.data.Person;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonListAdapter extends ArrayAdapter<Person> {

	private Context context;
	private int resourceId;
	private LayoutInflater inflater;
	
	public PersonListAdapter(Context context, int textViewResourceId, List<Person> objects) {
		super(context, textViewResourceId, objects);
		this.resourceId = textViewResourceId;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(resourceId, parent, false);
		}
		
		Person user = getItem(position);
		//Person user = listPerson.get(position);
		TextView nameView = (TextView) convertView.findViewById(R.id.item_name_text);
		TextView firstLineView = (TextView) convertView.findViewById(R.id.item_first_line_text);
		TextView secondLineView = (TextView) convertView.findViewById(R.id.item_second_line_text);
		TextView sexLineView = (TextView) convertView.findViewById(R.id.item_sex_text);
		ImageView photoView = (ImageView) convertView.findViewById(R.id.item_photography_view);
		
		if(user.isCharged)
			convertView.setBackgroundColor(Color.GRAY);
		
		StringBuffer tmp = null;
		
		// Surname and given names
        tmp = new StringBuffer();
        tmp.append(user.getSurname());
        tmp.append(' ');
        
        for (int i = 0; i < user.getGivenNames().size() - 1; ++i) {
        	tmp.append(user.getGivenNames().get(i));
        	tmp.append(", ");
        }
        tmp.append(user.getGivenNames().get(user.getGivenNames().size() - 1));
        nameView.setText(tmp.toString());
        // Birthdate
        tmp = new StringBuffer();
        tmp.append(user.getBirthdate());
        tmp.append(' ');
        firstLineView.setText(tmp.toString());
        // Nationality
        secondLineView.setText(user.getNationality().getCountrName());
        // Sex
        sexLineView.setText(user.getSex().toString());
        
        
        try {
			photoView.setImageBitmap(user.getThumbnailToBitmap());
		} catch (IOException e) {
			e.printStackTrace();
		}
    
        return convertView;
	}

	
	
	
}
