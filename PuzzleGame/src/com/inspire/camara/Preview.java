package com.inspire.camara;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class Preview extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = "Preview";

    static SurfaceHolder mHolder;


    public static Camera camera;
    static Camera.Parameters parameters;
 static   int m=CameraDemo.z;
    Preview(Context context) {
        super(context);
        
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(final SurfaceHolder holder) {
    	
        // The Surface has been created, acquire the camera and tell it where
        // to draw.
    	if(CameraDemo.z==0){
    	 camera = Camera.open();
    	 System.out.println("khkjghhh1111111222354234");
    	}
    	
    	
        try {
        	
        	 
			camera.setPreviewDisplay(holder);
			
			

	
			
			camera.setPreviewCallback(new PreviewCallback() {

				public void onPreviewFrame(byte[] data, Camera arg1) {
					FileOutputStream outStream = null;
					try {
						outStream = new FileOutputStream(String.format("/sdcard/%d.jpg", System.currentTimeMillis()));	
						//outStream.write(data);
						outStream.close();
						Log.d(TAG, "onPreviewFrame - wrote bytes: " + data.length);
						
						
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
					}
						Preview.this.invalidate();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
       
    }

    
	public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface will be destroyed when we return, so stop the preview.
        // Because the CameraDevice object is not a shared resource, it's very
        // important to release it when the activity is paused.
    	
    	 camera.stopPreview();
//    	  if(camera==null){
//    		  camera=Camera.open();
//    	  }
//    	  else
//          camera.release();
       
      // camera = null;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // Now that the size is known, set up the camera parameters and begin
        // the preview.
    	if(CameraDemo.z!=0){
System.out.println("khkdhsakjfhkja");
    	}
    	parameters=camera.getParameters();
    	
//    	parameters.setColorEffect(Camera.Parameters.EFFECT_NEGATIVE);
try{
    	switch(CameraDemo.z){
    	case 0:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
    	case 1:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
    		break;
    	case 2:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_SEPIA);
    		break;
    	case 3:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_NEGATIVE);
    		break;
    	case 4:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_MONO);
    		break;
    	case 5:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_POSTERIZE);
    		break;
    	case 6:
    		parameters.setColorEffect(Camera.Parameters.EFFECT_WHITEBOARD);
    		break;
    	
    	}
    	

    	camera.setParameters(parameters);
    	

			camera.setPreviewDisplay(mHolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 camera.startPreview();
        
    }

    @Override
    public void draw(Canvas canvas) {
    		super.draw(canvas);
    		Paint p= new Paint(Color.RED);
    		Log.d(TAG,"draw");
    		canvas.drawText("PREVIEW", canvas.getWidth()/2, canvas.getHeight()/2, p );
    }
   

}