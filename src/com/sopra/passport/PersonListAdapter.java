package com.sopra.passport;

import java.io.IOException;
import java.util.List;

import com.sopra.passport.data.Person;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Class adapter used for customizing the person ListView.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class PersonListAdapter extends ArrayAdapter<Person> {

	private Context mContext;
	private int mResourceId;
	private LayoutInflater mInflater;
	
	public PersonListAdapter(Context context, int textViewResourceId, List<Person> objects) {
		super(context, textViewResourceId, objects);
		this.mResourceId = textViewResourceId;
		this.mInflater = LayoutInflater.from(context);
		this.mContext = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			mInflater = ((Activity) mContext).getLayoutInflater();
			convertView = mInflater.inflate(mResourceId, parent, false);
		}
		
		Person user = getItem(position);
		//Person user = listPerson.get(position);
		TextView nameView = (TextView) convertView.findViewById(R.id.item_name_text);
		TextView firstLineView = (TextView) convertView.findViewById(R.id.item_first_line_text);
		TextView secondLineView = (TextView) convertView.findViewById(R.id.item_second_line_text);
		TextView sexLineView = (TextView) convertView.findViewById(R.id.item_sex_text);
		ImageView photoView = (ImageView) convertView.findViewById(R.id.item_photography_view);
		
		if(user.isCharged)
			convertView.setBackgroundResource(R.drawable.charged_selector);
		
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
