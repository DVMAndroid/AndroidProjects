package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.send).setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, Notificationmanager.class);
				
				PendingIntent pending=PendingIntent.getActivity(MainActivity.this, 0, intent,0);
				
				NotificationManager notificationmanager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				
				Notification notification=new Notification(R.drawable.ic_launcher,"Notication",System.currentTimeMillis());
				
				notification.setLatestEventInfo(MainActivity.this, "", "",pending);
				
				notification.flags=Notification.FLAG_AUTO_CANCEL;
				
				notificationmanager.notify(0, notification);
			}
		});
	}

	

}
