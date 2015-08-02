package com.mahesh.inspire;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class creditcard extends Activity{
	
	EditText name,mobile,card,date;
	Button submit;
	
	
	protected void onCreate(Bundle savedInstances)
	{
		super.onCreate(savedInstances);
		
		setContentView(R.layout.creditcard);
		
        name =(EditText) findViewById(R.id.name);
		
		mobile=(EditText) findViewById(R.id.mobile);
		
		card=(EditText) findViewById(R.id.cardno);
		
		date=(EditText) findViewById(R.id.date);
		
		
		submit=(Button)findViewById(R.id.creditsubmit);
		
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name1=name.getText().toString();
				String mobile1=mobile.getText().toString();
				String card1=card.getText().toString();
				String date1=date.getText().toString();
				if(name1.length()>0&&mobile1.length()>0&&card1.length()>0&&date1.length()>0)
				{
				Intent submit=new Intent(getApplicationContext(), submit.class);
				
				startActivity(submit);
				Toast.makeText(getApplicationContext(), "Accepted", 3000).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "please enret details", 3000).show();
				}
				
			}
		});
	}


	}


