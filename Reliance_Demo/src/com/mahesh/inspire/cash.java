package com.mahesh.inspire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class cash extends Activity {

  Button cash,credit;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cash);
		
		cash=(Button) findViewById(R.id.cash);
		
		credit=(Button) findViewById(R.id.credit);
		
		cash.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent c=new Intent(getApplicationContext(), submit.class);
				startActivity(c);
				
				Toast.makeText(getApplicationContext(), "Please pay bill", 8000).show();
					
					
				
			}
		});
		
		
		credit.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			Intent c=new Intent(getApplicationContext(), creditcard.class);
			startActivity(c);
			
			Toast.makeText(getApplicationContext(), "", 3000).show();
				
				
			}
		});
		
	}
	

}
