package com.inspire.camara;


import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class CameraDemo extends Activity {
	private static final String TAG = "CameraDemo";
	Camera camera;
	Preview preview;
	Button buttonClick,next,color;
	public static  byte[] bitmap;
	SurfaceHolder holder=Preview.mHolder;
	static Camera.Parameters parameters=Preview.parameters;
        static int z;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 color=(Button)findViewById(R.id.buttonClick1);
		 next = (Button)findViewById(R.id.next);
			next.setVisibility(View.GONE);

			buttonClick = (Button) findViewById(R.id.buttonClick);
			registerForContextMenu(color);
			
		preview = new Preview(this);
		((FrameLayout) findViewById(R.id.preview)).addView(preview);

		buttonClick = (Button) findViewById(R.id.buttonClick);
		buttonClick.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				preview.camera.takePicture(shutterCallback, rawCallback, jpegCallback);
				next.setVisibility(View.VISIBLE);
			}
		});
		
		next.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),Demo.class);
				startActivity(intent);
				finish();
				
			}
		});

		
		
		Log.d(TAG, "onCreate'd");
	}
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	     menu.setHeaderTitle("Color Effects");  
   	     menu.add(0, 1, 0, "Normal");  
   	     menu.add(0, 2, 0, "Sepia");
   	     menu.add(0, 3, 0, "Negative");
   	     menu.add(0, 4, 0, "Mono");
   	     menu.add(0, 5, 0, "Posterize");
   	     menu.add(0, 6, 0, "WhiteBoard");

 

	}


	@Override
	public boolean onContextItemSelected(MenuItem item) {

		Intent i=new Intent(getApplicationContext(),handler.class);
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case 1:
			z=1;
//			 parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
			startActivity(i);
			 finish();
         	break;

		case 2:
			z=2;
			
			startActivity(i);
			finish();
			break;
		case 3:
			z=3;
			startActivity(i);
			finish();
			break;
			
	      case 4:
				z=4;
				startActivity(i);
				finish();
				break;
		    case 5:
			        z=5;
			        startActivity(i);
			        finish();
			        break;
			case 6:
						z=6;
						startActivity(i);
						finish();
						break;
		}
		
		return true;
	}


	ShutterCallback shutterCallback = new ShutterCallback() {
		public void onShutter() {
			Log.d(TAG, "onShutter'd");
		}
	};

	/** Handles data for raw picture */
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			Log.d(TAG, "onPictureTaken - raw");
		}
	};

	/** Handles data for jpeg picture */
	PictureCallback jpegCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			
			
            byte[] image=data;
			
			//Bitmap map=BitmapFactory.decodeByteArray(image, 0, image.length);
						
			setBitMap(image);
						
			Log.d(TAG, "onPictureTaken - jpeg");
		}
	};
	

 public void setBitMap(byte[] image)

 {
   bitmap=image;
		
 }
 public byte[] getBitMap()

 {
 return bitmap;
	
	
 }
 public static void para(){
	 if(z==1){
	 parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);

	 }
	 if(z==2){
		 parameters.setColorEffect(Camera.Parameters.EFFECT_SEPIA);}
	 if(z==3){
		 parameters.setColorEffect(Camera.Parameters.EFFECT_NEGATIVE);}
	 if(z==4){
		 parameters.setColorEffect(Camera.Parameters.EFFECT_MONO);}
	 if(z==5){
		 parameters.setColorEffect(Camera.Parameters.EFFECT_POSTERIZE);}
	 if(z==6){
		 parameters.setColorEffect(Camera.Parameters.EFFECT_WHITEBOARD);}
	 
 }
	

}


