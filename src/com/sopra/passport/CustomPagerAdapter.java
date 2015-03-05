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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * This class provides the slider adapter for displaying pictures as a gallery 
 * using a custom objects.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class CustomPagerAdapter extends PagerAdapter {

	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private ArrayList<Blob> mListImages;
	private HashMap<Integer, Bitmap> mArrayElementsToShow;
	private boolean mExpoState = true;
	private int mPosix = 0;
	private int mSize;

	public CustomPagerAdapter(Context context) {
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
	}

	public CustomPagerAdapter(Context context , ArrayList<Blob> listImages,boolean isForExposition,int position){
		this.mListImages = listImages; 
		this.mSize = listImages.size();
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mArrayElementsToShow = new HashMap<Integer,Bitmap>();
		this.mExpoState = isForExposition;
		this.mPosix = position;
	}

	@Override
	public int getCount() {
		return mListImages.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View itemView = null;
		final int pos = (position + mPosix)%(mSize);

		if(mExpoState){
			itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
			TouchImageView imageView = (TouchImageView) itemView.findViewById(R.id.imageView);
			imageView.setImageBitmap(getFingerPrint(pos));

			ImageView mImageView = (ImageView) itemView.findViewById(R.id.finger);
			int resId = mContext.getResources().getIdentifier("fingerprint_"+mListImages.get(pos).getFinger(), "drawable", mContext.getPackageName());
			mImageView.setImageResource(resId);
		} else {
			itemView = mLayoutInflater.inflate(R.layout.pager_simple, container, false);
			ImageView imageView = (ImageView) itemView.findViewById(R.id.simpleImageView);
			imageView.setImageBitmap(getFingerPrint(pos));
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(mContext, GalleryActivity.class);
					intent.putExtra("fingers", mListImages);
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
		if(mArrayElementsToShow.containsKey(position))
			return mArrayElementsToShow.get(position);

		Bitmap image = null;
		try {
			image = ImageConverter.getBitmap(mListImages.get(position));
		} catch (IOException e) {
			e.printStackTrace();
		}

		mArrayElementsToShow.put(position, image);
		return image;
	}
}
