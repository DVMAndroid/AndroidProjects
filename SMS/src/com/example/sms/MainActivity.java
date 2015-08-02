package com.example.sms;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText edittext;
	Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edittext=(EditText) findViewById(R.id.number);
		
		send=(Button) findViewById(R.id.send);
		
		send.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@SuppressLint("ServiceCast")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				String s=edittext.getText().toString();
				
				@SuppressWarnings("deprecation")
				
				android.telephony.SmsManager sms=(android.telephony.SmsManager) getSystemService(TELEPHONY_SERVICE);
				sms.sendTextMessage(s, null, "This is message", null, null);
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
