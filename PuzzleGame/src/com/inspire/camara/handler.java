package com.inspire.camara;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class handler extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hi);
		Runnable r=new Runnable() {
			
			public void run() {
				try {
					Thread.sleep(200);
					Intent i=new Intent(getApplicationContext(),CameraDemo.class);
					startActivity(i);
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};
		new Thread(r).start();
	}
  
	
	

}
