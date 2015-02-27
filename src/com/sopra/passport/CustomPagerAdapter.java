package com.sopra.passport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sopra.passport.data.Blob;
import com.sopra.passport.utils.ImageConverter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomPagerAdapter extends PagerAdapter {

	private Context mContext;
	private LayoutInflater  mLayoutInflater;
	private ArrayList<Blob> listImages;
	private HashMap<Integer, Bitmap> ArrayElementsToShow;
	private boolean expoState = true;
	private int posix = 0;
	private int size;
    
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
    }
    
    public CustomPagerAdapter(Context context , ArrayList<Blob> listImages,boolean isForExposition,int position){
    	this.listImages = listImages; 
    	this.size = listImages.size();
    	mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ArrayElementsToShow = new HashMap<Integer,Bitmap>();
        this.expoState = isForExposition;
        this.posix = position;
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
	    public Object instantiateItem(ViewGroup container,int position) {
	    	View itemView = null;
	    	final int pos = (position + posix)%(size);
	    	if(expoState){
		        itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
		        TouchImageView imageView = (TouchImageView) itemView.findViewById(R.id.imageView);
		        imageView.setImageBitmap(getFingerPrint(pos));
	    	}else{
	    		itemView = mLayoutInflater.inflate(R.layout.pager_simple, container, false);
			    ImageView imageView = (ImageView) itemView.findViewById(R.id.simpleImageView);
			    imageView.setImageBitmap(getFingerPrint(pos));
			    imageView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(mContext, ShowGallery.class);
						intent.putExtra("fingers", listImages);
						intent.putExtra("position", pos);	
						mContext.startActivity(intent);
					}
				});
	    	}
		        container.addView(itemView);
		        return itemView;
	    	
	    	
	      
	    }
	 
	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        container.removeView((LinearLayout) object);
	    }
	    
	    
	    private Bitmap getFingerPrint(int position){
	    	if(ArrayElementsToShow.containsKey(position)){
	    		return ArrayElementsToShow.get(position);
	    	}
	    	Bitmap image = null;
				try {
					image = ImageConverter.getBitmap(listImages.get(position));
				} catch (IOException e) {
					e.printStackTrace();
				}
			ArrayElementsToShow.put(position, image);
			return image;
	    }
	    

}
