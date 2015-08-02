package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

public class broadclass extends BroadcastReceiver{

	private Context context;
	private Intent intent;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		
		Toast.makeText(context, "getting"+intent.getAction(), 3000).show();
		
		 
		
	}
	
	
	
	
}
