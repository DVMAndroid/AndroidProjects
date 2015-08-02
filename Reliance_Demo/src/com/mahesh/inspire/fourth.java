package com.mahesh.inspire;


import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fourth extends Activity implements OnClickListener {

	public EditText ed;
	public Button bt;
	public Dialog dialog;
	TextView qav1,qav2,qav3,qav4;
	public ImageView img1,img2,img3,img4; 
	
	public String s,quant,s1;
	Editable ed1;
	public int value1,a,quantity,quanti,x,y,value_for_fifth;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.fourth);
         
        final int   CUSTOM_DIALOG=1;
         qav1=(TextView)findViewById(R.id.qa1);
         qav2=(TextView)findViewById(R.id.qa2);
         qav3=(TextView)findViewById(R.id.qa3);
         qav4=(TextView)findViewById(R.id.qa4);
         
         img1=(ImageView)findViewById(R.id.kit);
         img1.setOnClickListener(this);
         img2=(ImageView)findViewById(R.id.mob);
         img2.setOnClickListener(this);
         img3=(ImageView)findViewById(R.id.lap);
         img3.setOnClickListener(this);
         img4=(ImageView)findViewById(R.id.bran);
         img4.setOnClickListener(this);
        
        TextView r5=(TextView)findViewById(R.id.rate5);
		 	
	CheckBox c1=(CheckBox)findViewById(R.id.cb1);
	CheckBox c2=(CheckBox)findViewById(R.id.cb2);
	CheckBox c3=(CheckBox)findViewById(R.id.cb3);
	CheckBox c4=(CheckBox)findViewById(R.id.cb4);
	c1.setOnCheckedChangeListener(new OnCheckedChangeListener()
	{
		
		public void onCheckedChanged(CompoundButton v, boolean flag)
		{
				if(v.isChecked())
				{
					
				a=1;
				
					showDialog(CUSTOM_DIALOG);
				Log.d("show dialog", "Custom dialog");
				}
			else{
			a=1;
			if(value1!=0)
			{
			remove();
			GlobalData.i.remove(""+x);
			GlobalData.price.remove("Rs. "+y);
				GlobalData.items.remove("Awindow AC one");
				update(value1);
			}
			}
			Toast.makeText(getApplicationContext(), ""+a, 3000).show();
			
			}
		
		
	});
	
c2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		
		public void onCheckedChanged(CompoundButton v, boolean flag) {
			
			if(v.isChecked()){
				a=2;
				
				showDialog(CUSTOM_DIALOG);
				//Toast.makeText(getApplicationContext(), ""+s, 4000).show();
				
			}
			
			else{
				a=2;
				if(value1!=0)
				{
				remove();
				GlobalData.price.remove("Rs. "+y);
				GlobalData.i.remove(""+x);
				
				update(value1);
			}
			}
		}
	});
	
c3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	
	
	public void onCheckedChanged(CompoundButton v, boolean flag) {
		
		if(v.isChecked()){
			a=3;
		
			showDialog(CUSTOM_DIALOG);
			
		}
		
		else{
			a=3;
			if(value1!=0)
			{
			remove();
			GlobalData.price.remove("Rs. "+y);
			GlobalData.i.remove(""+x);
			GlobalData.items.remove("AC three");
			update(value1);
		}
		}
	}
});

c4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	
	
	public void onCheckedChanged(CompoundButton v, boolean flag) {
		
		if(v.isChecked()){
			a=4;
			
			showDialog(CUSTOM_DIALOG);
			
		}
		
		else{
			a=4;
			if(value1!=0)
			{
			remove();
			GlobalData.price.remove("Rs. "+y);
			GlobalData.i.remove(""+x);
			GlobalData.items.remove("AC four");
			update(value1);
		}
		}
	}
});
TextView t3=(TextView)findViewById(R.id.detail3);
//t3.setOnClickListener(this);
TextView t5=(TextView)findViewById(R.id.detail5);
//t5.setOnClickListener(this);
Button bv1=(Button)findViewById(R.id.btnv1);
bv1.setOnClickListener(this);
Button bv2=(Button)findViewById(R.id.btnv2);
//bv2.setOnClickListener(this);
	}

public void onClick(View v) {
	
	if(v.getId()==R.id.detail3){
		call(GlobalData.ph_num1);
		
	}
	else if(v.getId()==R.id.detail5){
		 call(GlobalData.ph_num2);
		
	}
	else if(v.getId()==R.id.btnv2){
		Intent vin=new Intent(this,mobile.class);
		startActivity(vin);
	}
	else if(v.getId()==R.id.btnv1){
		Intent in = new Intent(this,fifth.class);
		in.putExtra("key",value_for_fifth );
		startActivity(in);
		
		}
	if(v.getId()==R.id.kit){
		Intent vin=new Intent(this,third.class);
		//vin.putExtra("key", num2);
		startActivity(vin);
		
	}
 if(v.getId()==R.id.mob){
		Intent vin=new Intent(this,mobile.class);
		//vin.putExtra("key", num2);
		startActivity(vin);
		
	}
 if(v.getId()==R.id.lap){
		Intent vin=new Intent(this,laptap.class);
		//vin.putExtra("key", num2);
		startActivity(vin);
		
	}
 if(v.getId()==R.id.bran){
		Intent vin=new Intent(this,Branch.class);
		//vin.putExtra("key", num2);
		startActivity(vin);
		
	}

	else if(v.getId()==R.id.conform){
		
		dialog.dismiss();
		  
	     String s=ed.getText().toString();
	    
		 write(s);
		
		}
else if(v.getId()==R.id.cancel){
		
		dialog.dismiss();
		  
	     String s=ed.getText().toString();
	    
		 write(s);
		
		}
}


protected Dialog onCreateDialog(int id) {
	
	switch(id)
	{
	case 1:
		
		 dialog = new Dialog(fourth.this);

		dialog.setContentView(R.layout.custom_dialog);
		dialog.setTitle("Enter Quantity");
		 LayoutParams lp=dialog.getWindow().getAttributes();    
         lp.height=300;lp.width=300;
		  TextView txt =(TextView)dialog.findViewById(R.id.cdtxt1);
		//Toast.makeText(getApplicationContext(), "Dailog box", 4000).show();
		  Button btn_ok= (Button)dialog.findViewById(R.id.conform);
	  		Button btn_cancel=(Button)dialog.findViewById(R.id.cancel);
	  		btn_cancel.setOnClickListener(new OnClickListener() {
				
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
	  		btn_ok.setOnClickListener(this);
	  		
	  		dialog.show();
			
			}
		 ed=(EditText)dialog.findViewById(R.id.edt);
		 return dialog;
	}
	

private void write(String s) {
	
	switch(a){
	case 1:
		quantity=Integer.parseInt(s);
		//Toast.makeText(getApplicationContext(), ""+quantity, 4000).show();
		qav1.setText(s);
		
		value1=value1+quantity*9000;
		x=quantity;
		y=quantity*9000;
		GlobalData.price.add("Rs. "+y);
		GlobalData.i.add(""+s);
		//Toast.makeText(getApplicationContext(), s, 4000).show();
		GlobalData.items.add("Window AC one");
		
		 update(value1);
		
		 break;
	case 2:
		quantity=Integer.parseInt(s);
		qav2.setText(s);
		x=quantity;
		value1=value1+quantity*11000;
		GlobalData.i.add(""+s);
		y=quantity*11000;
		GlobalData.price.add("Rs. "+y);
		GlobalData.items.add("Window AC two");
		
		 
		 update(value1);
		break;
	case 3:
		quantity=Integer.parseInt(s);
		qav3.setText(s);
		GlobalData.i.add(""+s);
		x=quantity;
		value1=value1+quantity*12000;
		y=quantity*12000;
		GlobalData.price.add("Rs. "+y);
		GlobalData.items.add("AC Three");
		update(value1);
		break;
	case 4:
		quantity=Integer.parseInt(s);
		qav4.setText(s);
		GlobalData.i.add(""+s);
		value1=value1+quantity*15000;
		x=quantity;
		y=quantity*15000;
		GlobalData.price.add("Rs. "+y);
		GlobalData.items.add("AC four");
		 update(value1);
		break;
	}
	
}
private void remove(){
	switch(a){
	case 1:
		 quant=qav1.getText().toString();
		 quanti=Integer.parseInt(quant);
		value1=value1-(quanti)*9000;
		qav1.setText("1");
		break;
	case 2:
	 quant=qav2.getText().toString();
		 quanti=Integer.parseInt(quant);
		value1=value1-(quanti)*11000;
		qav2.setText("1");
		break;
	case 3:
		quant=qav3.getText().toString();
		 quanti=Integer.parseInt(quant);
		value1=value1-(quanti)*12000;
		qav3.setText("1");
		break;
	case 4:
		quant=qav4.getText().toString();
		 quanti=Integer.parseInt(quant);
		value1=value1-(quanti)*15000;
		qav4.setText("1");
		break;
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
	
private void update(int Amount){
	
	//Toast.makeText(getApplicationContext(), "ravi", 4000).show();
	 GlobalData.page_4_value=Amount+GlobalData.page_3_value+GlobalData.page_5_value+GlobalData.page_6_value;
	TextView r5=(TextView)findViewById(R.id.rate5);
	
	r5.setText("RS. "+GlobalData.page_4_value+"/-");
	value_for_fifth=GlobalData.page_4_value;
}
private void call(String x){
	
	Intent DialIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+x));
	 startActivity(DialIntent);
}
private void move(){
	   Intent in =new Intent(getApplicationContext(), RelianceActivity.class);
	   startActivity(in);
}

	
}
	
			
		
	

		
		
		
	
	
	
	
	
	
	
		
		
	

	
		
	
	
