package com.sopra.passport;

import java.io.IOException;
import java.util.ArrayList;

import com.sopra.passport.data.Blob;
import com.sopra.passport.utils.ImageConverter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomPagerAdapter extends PagerAdapter {

	Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Blob> listImages;
    
  
 
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    public CustomPagerAdapter(Context context , ArrayList<Blob> listImages){
    	this.listImages = listImages; 
    	mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
	@Override
	public int getCount() {
		return listImages.size();
	}

	 @Override
	    public boolean isViewFromObject(View view, Object object) {
	        return view == ((LinearLayout) object);
	    }
	 
	    @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
	 
	        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
	        Bitmap image = null;
			try {
				image = ImageConverter.getBitmap(listImages.get(position));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        imageView.setImageBitmap(image);
	 
	        container.addView(itemView);
	 
	        return itemView;
	    }
	 
	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        container.removeView((LinearLayout) object);
	    }

}
