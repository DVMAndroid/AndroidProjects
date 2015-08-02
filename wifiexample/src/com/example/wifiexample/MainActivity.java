package com.example.wifiexample;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	    @Override
	
	    protected void onCreate(Bundle savedInstanceState) {
	
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.activity_main);
	
	        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
	
	        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

	            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	
	                if (isChecked) {

	                    toggleWiFi(true);
	
	                    Toast.makeText(getApplicationContext(), "Wi-Fi Enabled!", Toast.LENGTH_LONG).show();
	
	                } else {
	
	                    toggleWiFi(false);
	
	                    Toast.makeText(getApplicationContext(), "Wi-Fi Disabled!", Toast.LENGTH_LONG).show();
	
	                }
	
	            }
	
	        });
	
	    }
	
	    public void toggleWiFi(boolean status) {
	
	        WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
	
	        if (status == true && !wifiManager.isWifiEnabled()) {
	
	            wifiManager.setWifiEnabled(true);
	
	        } else if (status == false && wifiManager.isWifiEnabled()) {
	
	            wifiManager.setWifiEnabled(false);
	
	        }
	
	    }
	
	}

