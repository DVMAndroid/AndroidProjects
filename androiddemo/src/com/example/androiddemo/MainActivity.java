package com.example.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText edittext,edittext2;

	TextView textview;
	Button button,button2,button3,button4;

	//View textview,button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		setContentView(R.layout.activity_calc);
		Log.v("oncreate","invoke");

		edittext=(EditText) findViewById(R.id.edit);
		edittext2=(EditText) findViewById(R.id.edit2);

		textview=(TextView) findViewById(R.id.text);
		button=(Button) findViewById(R.id.button);
		button2=(Button) findViewById(R.id.button1);
		button3=(Button) findViewById(R.id.button2);
		button4=(Button) findViewById(R.id.button3);

		button.setOnClickListener(new mybutton());

		button2.setOnClickListener(new mybutton());
		
		//		textview=findViewById(R.id.text);
		//		button=findViewById(R.id.button);



	}


	public class mybutton implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String s1=edittext.getText().toString();
			String s2=edittext2.getText().toString();

			int i1=Integer.parseInt(s1);
			int i2=Integer.parseInt(s2);

			if(v.getId()==R.id.button)
			{
			int i=i1+i2;
			textview.setText(""+i);
				
				
				
			}
			if(v.getId()==R.id.button1)
			{
				int i=i1-i2;
				textview.setText(""+i);
			}

			
		}

	}

	public void onStart()
	{
		super.onStart();
		Log.v("Onstart","invoke");
	}

	public void onResume()
	{
		super.onResume();
		Log.v("onresume","invoke");

	}
	public void onPause()
	{
		super.onPause();
		Log.v("onpause","invoke");

	}
	public void onStop()
	{
		super.onStop();
		Log.v("onstop","invoke");

	}
	public void onDestroy()
	{
		super.onDestroy();
		Log.v("ondestroy","invoke");

	}
	public void onRestart()
	{
		super.onRestart();
		Log.v("onrestart","invoke");
	}
	public void onSavedInstanceState(Bundle outState)
	{
		
		super.onSaveInstanceState(outState);		
		Log.v("onSaveInstanceState","invoke");
		
		
		
	}

}
