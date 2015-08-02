package com.mahesh.inspire;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class order extends Activity implements OnClickListener {
	 EditText name,mob,addr;
	 String s1,s2,s3;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.address);
        name=(EditText)findViewById(R.id.widget35);
        mob=(EditText)findViewById(R.id.widget37);
        addr=(EditText)findViewById(R.id.widget39);
        
         TextView t3=(TextView)findViewById(R.id.detail3);

         t3.setOnClickListener(this);
         TextView t5=(TextView)findViewById(R.id.detail5);
         Button bt=(Button)findViewById(R.id.submit);
         bt.setOnClickListener(this);
	}

	
	public void onClick(View v) {
		s1=name.getText().toString();
        s2=mob.getText().toString();
        s3=addr.getText().toString();
        
		int i,i1,i2;
		i=s1.length();
		i1=s2.length();
		i2=s3.length();
			
			if(i>0 && i1>0 && i2>0)// && s2.length()>0&&s3.length()){
			{
			Intent in = new Intent(getApplicationContext(), cash.class);
			startActivity(in);
		}
			else{
				Toast.makeText(getApplicationContext(), "please enter your details", 20000).show();
			}
				
}
	public boolean onCreateOptionsMenu(Menu menu){

	    
	   	menu.add(0, 1, 0,"Home");
	   	menu.add(0, 2, 0,"Contact Us");
	   	menu.add(0, 3, 0,"Terms&Conditions");
	   return true;
	   }
	   public boolean onOptionsItemSelected(MenuItem m)
	   {
	   switch(m.getItemId()){
	   case 1:
		  move();
		   break;
	   case 2:
		   
		 move();
		   break;
	   case 3:
		   move();
		   break;
	   }
	   
	   return true;
	   }
	   private void move(){
		   Intent in =new Intent(getApplicationContext(), RelianceActivity.class);
		   startActivity(in);
	}


	private void call(String x){
	
	Intent DialIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+x));
	 startActivity(DialIntent);
}
}
