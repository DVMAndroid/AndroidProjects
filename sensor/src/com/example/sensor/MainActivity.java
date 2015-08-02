package com.example.sensor;



import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	
	Sensor accelemeter;
	SensorManager sm;
	TextView acceleration;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 sm=(SensorManager)getSystemService(SENSOR_SERVICE);
	        accelemeter=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	        
	        sm.registerListener(this, accelemeter, SensorManager.SENSOR_DELAY_NORMAL);
	        
	        acceleration=(TextView) findViewById(R.id.acceleration);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		 acceleration.setText("X:"+event.values[0]+"\nY:"+event.values[1]+"\nZ:"+event.values[2]);

	}

}
