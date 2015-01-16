package com.sopra.passport;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ZoomImageView extends ImageView {

	private static final String TAG = "Touch";

	// These matrices will be used to move and zoom image
	Matrix matrix = new Matrix();
	Matrix savedMatrix = new Matrix();  

	// We can be in one of these 3 states
	static final int NONE = 0;
	static final int DRAG = 1;
	static final int ZOOM = 2;
	static final int DRAW =3;
	int mode = NONE;

	// Remember some things for zooming
	PointF start = new PointF();
	PointF mid = new PointF();
	float oldDist = 1f;

	// Limit zoomable/pannable image
	private float[] matrixValues = new float[9];
	private float maxZoom;
	private float minZoom;
	private float height;
	private float width;
	private RectF viewRect;

	public ZoomImageView(Context context) {
		super(context);
	}
	
	public ZoomImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/////////************ touch events functions **************////////////////////
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){  init();   }
	}
	
	private void init() {
		maxZoom = 4;
		minZoom = 0.25f;
		height =this.getDrawable().getIntrinsicHeight()+20;
		width = this.getDrawable().getIntrinsicWidth()+20;
		viewRect = new RectF(0, 0, this.getWidth()+20, this.getHeight()+20);
	}

	/////////************touch events for image Moving, panning and zooming   ***********///
	public boolean onTouch(View v, MotionEvent event) {

		// Dump touch event to log
		// dumpEvent(event);
		// Handle touch events here...
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			savedMatrix.set(matrix);
			start.set(event.getX(), event.getY());
			// Log.d(TAG, "mode=DRAG");
			mode = DRAG;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			oldDist = spacing(event);
			// Log.d(TAG, "oldDist=" + oldDist);
			if (oldDist > 10f) {
				savedMatrix.set(matrix);
				midPoint(mid, event);
				mode = ZOOM;
				// Log.d(TAG, "mode=ZOOM");
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_POINTER_UP:
			mode = NONE;
			// Log.d(TAG, "mode=NONE");
			break;
		case MotionEvent.ACTION_MOVE:
			if (mode == DRAW){ onTouchEvent(event);}
			if (mode == DRAG) {
					///code for draging..        
			} 
			else if (mode == ZOOM) {
				float newDist = spacing(event);
				// Log.d(TAG, "newDist=" + newDist);
				if (newDist > 10f) {
					matrix.set(savedMatrix);
					float scale = newDist / oldDist;
					matrix.getValues(matrixValues);
					float currentScale = matrixValues[Matrix.MSCALE_X];
					// limit zoom
					if (scale * currentScale > maxZoom) {
						scale = maxZoom / currentScale; 
					}else if(scale * currentScale < minZoom){
						scale = minZoom / currentScale; 
					}
					matrix.postScale(scale, scale, mid.x, mid.y);
				}
			}
			break;
		}
		
		this.setImageMatrix(matrix);
		return true; // indicate event was handled
	}

	//*******************Determine the space between the first two fingers
	private float spacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
	}

	//************* Calculate the mid point of the first two fingers 
	private void midPoint(PointF point, MotionEvent event) {
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
}
