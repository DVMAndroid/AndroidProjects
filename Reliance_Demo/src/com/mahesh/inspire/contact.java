package com.mahesh.inspire;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class contact extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	public static String num1="0129 4161085";
	public static String num2="079 40089155";
	public static String num3="0124 4029099";
	public static String num4="022 30301111";
	public static String num5="0120 30334343";
	public static String num6="040 6462940";
	public static String num7="080 41529725";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

    	TextView t1=(TextView)findViewById(R.id.title1);
    	
    	t1.setOnClickListener(this);
    	TextView t2=(TextView)findViewById(R.id.title2);
    	
    	t2.setOnClickListener(this);

    	TextView t3=(TextView)findViewById(R.id.title3);
    	
    	t3.setOnClickListener(this);
    	TextView t4=(TextView)findViewById(R.id.title4);
    	
    	t4.setOnClickListener(this);

    	TextView t5=(TextView)findViewById(R.id.title5);
    	
    	t5.setOnClickListener(this);
    	TextView t6=(TextView)findViewById(R.id.title6);
    	
    	t6.setOnClickListener(this);

    	TextView t7=(TextView)findViewById(R.id.title7);
    	
    	t7.setOnClickListener(this);
TextView t8=(TextView)findViewById(R.id.weblink);
    	
    	t8.setOnClickListener(this);
    	
    	
    }
    public void onClick(View v) {
		  
		if(v.getId()==R.id.title1){
			//This is used to make a call for 6610 0044 number 
			call(contact.num1);
		}
		else if(v.getId()==R.id.title2){
			 //This is used to make a call for 6662 5454
			
			call(contact.num2);        
			
		}		
		     
		else if(v.getId()==R.id.title3){
				//This is used to make a call for 6610 0044 number 
				call(contact.num3);
				
			}
			else if(v.getId()==R.id.title4){
				 //This is used to make a call for 6662 5454
				
				call(contact.num4);          
				
			}
			    
			else if(v.getId()==R.id.title5){
					//This is used to make a call for 6610 0044 number 
					call(contact.num5);
					
				}
				else if(v.getId()==R.id.title6){
					 //This is used to make a call for 6662 5454
					
					call(contact.num6);
				      	
				}
				
					else if(v.getId()==R.id.title7){
						 //This is used to make a call for 6662 5454
						
						call(contact.num7);
					               
					}
					else if(v.getId()==R.id.weblink){
						 //This is used to make a call for 6662 5454
						
						 String url="http://www.reliancemart.com/";
						
						Intent i = new Intent(Intent.ACTION_VIEW);  
						i.setData(Uri.parse(url));  
						startActivity(i);
					      
					          
						
					}
					
}
	private void call(String num12) {
		// TODO Auto-generated method stub
		 Intent dailintent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num12));
  	   startActivity(dailintent);
		
	}
}