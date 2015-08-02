package com.example.servicesss;



import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	
	Button service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		service=(Button) findViewById(R.id.serve);
		
		service.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
//				Intent in=new Intent(MainActivity.this,serve.class);
//				startService(in);

				
				Intent in=new Intent(MainActivity.this,serve.class );
				
				PendingIntent pending=PendingIntent.getService(MainActivity.this,0,in,0);
				
				
				AlarmManager alarm=(AlarmManager) getSystemService(ALARM_SERVICE);
				
				alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2*1000, pending);
				
				
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
