package com.example.androiddemo;

import java.net.URI;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondScreen extends Activity {

	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_screen);
		
		button=(Button) findViewById(R.id.button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				/*Explicit Intent is used for starting External activities or user defined activities*/
				
		/*  1 ..Intent i=new Intent(SecondScreen.this, Trird.class);
				i.putExtra("key", "this is from second activity");
			startActivity(i);
			*/
				
	/*  2..	//startActivityForResult(intent, requestCode)
				Intent in=new Intent();
				in.setAction("getting");
				startActivity(in);
				*/
				/*Implicit intent are used for calling internal applications like message, browser */
			
				/* 3..*/
				
			Intent i=new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.google.com"));
			startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_screen, menu);
		return true;
	}

}
