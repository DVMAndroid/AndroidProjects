package com.mahesh.inspire;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import android.widget.Toast;

public class RelianceActivity extends Activity implements OnTouchListener {
   //Declaration
ImageView img;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
       // Toast.makeText(getApplicationContext(), "Please Click on the screen for menu", 400000).show();
        
        img=(ImageView)findViewById(R.id.img);
        
     //Listener for an Image   
        img.setOnTouchListener(this);
			
    }

	//Method to implement Listener
	public boolean onTouch(View arg0, MotionEvent arg1) {
		Intent i = new Intent(this,mainone.class);
		startActivity(i);
		
		return false;
	}
	
}

			

			
			

	