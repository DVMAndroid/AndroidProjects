package com.example.broadcast;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	
	Button  broad;
	
	broadclass bar=new broadclass();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		broad=(Button) findViewById(R.id.sendbroadcast);
		
		
		
		
		broad.setOnClickListener(new  mybroad());
		
	}

	public class mybroad implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int i=0;
			
			///////This is for single time invoking/////////////
			
//			Intent in=new Intent(MainActivity.this,broadclass.class);
//			sendBroadcast(in);
			
			
			
			
			////////Multiple time invoking////////////////////
			
			
			Intent in=new Intent(MainActivity.this,broadclass.class );
			
			PendingIntent pending=PendingIntent.getBroadcast(MainActivity.this,0,in,i);
			
			
			AlarmManager alarm=(AlarmManager) getSystemService(ALARM_SERVICE);
			
			alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2*1000, pending);
			
			//alarm.set(AlarmManager.RTC_WAKEUP,3*1000,pending);
			
			
			
			//alarm.cancel(pending);
			
			
		}
		
	}

}
