package com.example.servicesss;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class serve extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(getApplicationContext(), "Service Created",3000).show();
		
	}
	 @SuppressWarnings("deprecation")
	public void onStart(Intent intent, int startid) {
		 super.onStart(intent, startid);
		 Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		
		 }

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 Toast.makeText(this, "My Service Destroy", Toast.LENGTH_LONG).show();

		
	}


}
