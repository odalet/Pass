package com.sopra.passport;


import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;

import com.sopra.passport.data.User;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class UserActivity extends Activity {

	private Context context = this;
	private User user;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        User user = (User) getIntent().getSerializableExtra("user");
        this.user = user;
        
        initUI();
    }
    
    private void initUI()  {
    	TextView surnameView = (TextView)findViewById(R.id.user_surname_text);
        TextView givenNamesView = (TextView)findViewById(R.id.user_given_names_text);
        TextView nationalityView = (TextView)findViewById(R.id.user_nationality_text);
        TextView sexView = (TextView)findViewById(R.id.user_sex_text);
        TextView heightView = (TextView)findViewById(R.id.user_height_text);
        TextView eyesColorView = (TextView)findViewById(R.id.user_color_of_eyes_text);
        TextView birthdateView = (TextView)findViewById(R.id.user_birthdate_text);
        TextView birthplaceView = (TextView)findViewById(R.id.user_birthplace_text);
        TextView addressView = (TextView)findViewById(R.id.user_address_text);

        ImageButton photoView = (ImageButton)findViewById(R.id.user_photography_view);
        ImageView signatureView = (ImageView)findViewById(R.id.user_signature_view);
        ImageView fingerprintView = (ImageView)findViewById(R.id.user_fingerprint_view);
        
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
                Intent intent = new Intent(context, ImageViewer.class);
    			intent.putExtra("image", user.getPhoto() );
    			startActivity(intent);
   
            
            }
        });
        

        //ImageView photoView = (ImageView)findViewById(R.id.user_photography_view);


        StringBuffer tmp;
        
        surnameView.setText(user.getSurname());
        
        // Given names
        tmp = new StringBuffer();
        for (int i = 0; i < user.getGivenNames().size() - 1; ++i) {
        	tmp.append(user.getGivenNames().get(i));
        	tmp.append(", ");
        }
        tmp.append(user.getGivenNames().get(user.getGivenNames().size() - 1));
        givenNamesView.setText(tmp.toString());
        
        nationalityView.setText(user.getNationality());
        sexView.setText(user.getSex().toString());
        
        // Height
        tmp = new StringBuffer();
        tmp.append(Math.round(user.getHeight() * 100.) / 100.);
        tmp.append(" ");
        tmp.append(getString(R.string.height_unit_text));
        heightView.setText(tmp.toString());
        
        eyesColorView.setText(user.getEyesColor().toString());
        birthdateView.setText(user.getBirthdate().toString());
        birthplaceView.setText(user.getBirthplace());
        addressView.setText(user.getAddress());
        try {
			photoView.setImageBitmap(user.getPhotoToBitmap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Log.i("img", user.getFingerprint().toString());
        
    
        
        
       try {
		signatureView.setImageBitmap(user.getSignatureToBitmap());
       } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
       }
    }
    
    
    
  
}
