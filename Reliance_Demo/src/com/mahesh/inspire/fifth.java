package com.mahesh.inspire;

import java.util.ArrayList;

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

	
public class fifth extends Activity implements OnClickListener {
	
	 String p1,p2,p3,p4;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.displayitems);
	        TextView txt = (TextView)findViewById(R.id.items);
	        TextView txt1=(TextView)findViewById(R.id.Quan);
	        TextView txt2=(TextView)findViewById(R.id.sno);
	        TextView txt3=(TextView)findViewById(R.id.price);
	        Button order = (Button)findViewById(R.id.order);
	        order.setOnClickListener(this);
	        
	        Intent in = this.getIntent();
	        int value=in.getIntExtra("key", 0);
	        TextView price=(TextView)findViewById(R.id.rate5);
	        price.setText("Rs. "+value+" /-");
	        
	        
	        ArrayList<String> s1 = GlobalData.items;
	        int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	        
	         StringBuffer sb=new StringBuffer();
	        	 for(int x=0;x<s1.size();x++){
	        	sb=sb.append(" "+a[x]).append("\n").append("\n");
	        	p1=sb.toString();
	        	txt2.setText(p1);
	        }
	        
	       
	    	   StringBuffer sb1=new StringBuffer();
	    	   for(int z=0;z<s1.size();z++){
	        	sb1=sb1.append(s1.get(z)).append("\n").append("\n");
	        	 p2=sb1.toString();
	        	
		        
		        txt.setText(" "+p2);
	       }
	        	
	        ArrayList<String> s2=GlobalData.i;
	       
		    	   StringBuffer sb2=new StringBuffer();
		    	   for(int y=0;y<s2.size();y++){
		        	sb2=sb2.append(s2.get(y)).append("\n").append("\n");
		         p3=sb2.toString();
			        
			        txt1.setText(" "+p3);
		       }
		    	   
		    	   ArrayList<String> s3=GlobalData.price;
			       
		    	   StringBuffer sb3=new StringBuffer();
		    	   for(int z=0;z<s3.size();z++){
		        	sb3=sb3.append(s3.get(z)).append("\n").append("\n");
		         p4=sb3.toString();
			        
			        txt3.setText(" "+p4);
		       }
		    	   
		    	   TextView t3=(TextView)findViewById(R.id.detail3);

		    	   t3.setOnClickListener(this);
		    	   TextView t5=(TextView)findViewById(R.id.detail5);

		    	   t5.setOnClickListener(this);
	       
	 }

	public void onClick(View v) {
		if(v.getId()==R.id.detail3){
			
			call(GlobalData.ph_num1);
		}
		else if(v.getId()==R.id.detail5){
			
			call(GlobalData.ph_num2);
		}
		else if(v.getId()==R.id.order){
			Intent in = new Intent(getApplicationContext(), order.class);
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
	   private void move(){
		   Intent in =new Intent(getApplicationContext(), RelianceActivity.class);
		   startActivity(in);
	}
	private void call(String x){
	
	Intent DialIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+x));
	 startActivity(DialIntent);
}
		}
	
      
	 
	 
	 
	


