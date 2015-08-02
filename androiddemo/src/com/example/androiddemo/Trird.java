package com.example.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Trird extends Activity
{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.third);
	
	String s=getIntent().getStringExtra("key");
	
	Log.v("Data",(s!=null?s:"null value passed in as intent and has no extar key"));
	
}
}
