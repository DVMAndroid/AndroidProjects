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
import android.widget.TextView;

public class second extends Activity implements OnClickListener {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       setContentView(R.layout.second);
       //Declaring objects for UI elements and implementing Listeners
       Button b1=(Button)findViewById(R.id.btn1);
       b1.setOnClickListener(this);
       Button b2=(Button)findViewById(R.id.btn2);
       b2.setOnClickListener(this);
       Button b3=(Button)findViewById(R.id.btn3);
       b3.setOnClickListener(this);
       Button b4=(Button)findViewById(R.id.btn4);
       b4.setOnClickListener(this);
       //Object for the GlobalData
   
      
       
	
	TextView t3=(TextView)findViewById(R.id.detail3);
	
	t3.setOnClickListener(this);
	TextView t5=(TextView)findViewById(R.id.detail5);
	
	t5.setOnClickListener(this);
	}	
//Method for implementing listeners 
	public void onClick(View v) {
		  
		
		     
		if(v.getId()==R.id.detail3){
			//This is used to make a call for 6610 0044 number 
			call(GlobalData.ph_num1);
			
		}
		else if(v.getId()==R.id.detail5){
			 //This is used to make a call for 6662 5454
			
			call(GlobalData.ph_num2);
		      
		          
			
		}
		else if(v.getId()==R.id.btn1){
			//Moving to third screen
			Intent in=new Intent(this,third.class);
			startActivity(in);
		}
		else if(v.getId()==R.id.btn2){
			//Moving to fourth screen
			Intent in=new Intent(this,fourth.class);
			startActivity(in);
		}
		else if(v.getId()==R.id.btn3){
			//Moving to mobile screen
			Intent in=new Intent(this,mobile.class);
			startActivity(in);
		}
		else if(v.getId()==R.id.btn4){
			//Moving to laptap screen
			Intent in=new Intent(this,laptap.class);
			startActivity(in);
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
	
	       private void call(String num){
	    	   Intent dailintent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num));
	    	   startActivity(dailintent);
			
	    		
	       }
	       private void move(){
	    	   Intent in =new Intent(getApplicationContext(), RelianceActivity.class);
	    	   startActivity(in);
	       }
	       
}


	
		
	

