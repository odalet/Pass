package com.sopra.passport;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * This class used to implement the zoom functionality.
 * 
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class ZoomImageView extends ImageView {

	/**
	 * These matrices will be used to move and zoom image
	 */
	Matrix mMatrix = new Matrix();
	Matrix mSavedMatrix = new Matrix();  

	// We can be in one of these 3 states
	static final int NONE = 0;
	static final int DRAG = 1;
	static final int ZOOM = 2;
	static final int DRAW =3;
	int mode = NONE;

	// Remember some things for zooming
	PointF mStart = new PointF();
	PointF mMid = new PointF();
	float mOldDist = 1f;

	// Limit zoomable/pannable image
	private float[] mMatrixValues = new float[9];
	private float mMaxZoom;
	private float mMinZoom;

	public ZoomImageView(Context context) {
		super(context);
	}
	
	public ZoomImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
	 * Touch events methods.
	 * @param hasFocus
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus)
			init();
	}
	
	private void init() {
		mMaxZoom = 4;
		mMinZoom = 0.25f;

		// mHeight = this.getDrawable().getIntrinsicHeight() + 20;
		// mWidth = this.getDrawable().getIntrinsicWidth() + 20;
		// mViewRect = new RectF(0, 0, this.getWidth() + 20, this.getHeight() + 20);
	}

	/**
	 * Touch events for image moving, panning and zooming.
	 * @param v
	 * @param event
	 * @return boolean
	 */
	public boolean onTouch(View v, MotionEvent event) {

		// Dump touch event to log
		// dumpEvent(event);
		// Handle touch events here...
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			mSavedMatrix.set(mMatrix);
			mStart.set(event.getX(), event.getY());
			mode = DRAG;
			break;
			
		case MotionEvent.ACTION_POINTER_DOWN:
			mOldDist = spacing(event);
			if (mOldDist > 10f) {
				mSavedMatrix.set(mMatrix);
				midPoint(mMid, event);
				mode = ZOOM;
			}
			break;
			
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
			mode = NONE;
			break;
		case MotionEvent.ACTION_MOVE:
			if (mode == DRAW){ onTouchEvent(event);}
			if (mode == DRAG) {
				///code for draging..        
			} 
			else if (mode == ZOOM) {
				float newDist = spacing(event);
				if (newDist > 10f) {
					mMatrix.set(mSavedMatrix);
					float scale = newDist / mOldDist;
					mMatrix.getValues(mMatrixValues);
					float currentScale = mMatrixValues[Matrix.MSCALE_X];
					
					// limit zoom
					if (scale * currentScale > mMaxZoom) {
						scale = mMaxZoom / currentScale; 
					} else if(scale * currentScale < mMinZoom){
						scale = mMinZoom / currentScale; 
					}
					
					mMatrix.postScale(scale, scale, mMid.x, mMid.y);
				}
			}
			break;
		}
		
		this.setImageMatrix(mMatrix);
		return true; // indicate event was handled
	}

	/**
	 * Determines the space between the first two fingers.
	 * @param event
	 * @return
	 */
	private float spacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		
		return FloatMath.sqrt(x * x + y * y);
	}

	/**
	 * Calculates the mid point of the first two fingers. 
	 * @param point
	 * @param event
	 */
	private void midPoint(PointF point, MotionEvent event) {
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
}
