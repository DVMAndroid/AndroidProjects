package com.mahesh.inspire;




import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class third extends Activity implements OnClickListener {
	public int value,CUSTOM_DIALOG=1,a,quantity,quanti,x,y,value_for_fifth;
	public String quant;
	public Dialog dialog;
	public EditText ed;
	public TextView qanv1,qanv2,qanv3,qanv4;
	public ImageView img1,img2,img3,img4; 
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.third);
       TextView r5=(TextView)findViewById(R.id.rate5);
    	//r5.setText("RS. "+GlobalData.page_4_value+GlobalData.page_5_value+GlobalData.page_6_value+"/-");
    CheckBox c1=(CheckBox)findViewById(R.id.cb1);
	CheckBox c2=(CheckBox)findViewById(R.id.cb2);
	CheckBox c3=(CheckBox)findViewById(R.id.cb3);
	CheckBox c4=(CheckBox)findViewById(R.id.cb4);
	
	 qanv1=(TextView)findViewById(R.id.qa1);
     qanv1.setOnClickListener(this);
     qanv2=(TextView)findViewById(R.id.qa2);
     qanv2.setOnClickListener(this);
     qanv3=(TextView)findViewById(R.id.qa3);
     qanv3.setOnClickListener(this);
     qanv4=(TextView)findViewById(R.id.qa4);
     qanv4.setOnClickListener(this);
     img1=(ImageView)findViewById(R.id.apl);
     img1.setOnClickListener(this);
     img2=(ImageView)findViewById(R.id.mob);
     img2.setOnClickListener(this);
     img3=(ImageView)findViewById(R.id.lap);
     img3.setOnClickListener(this);
     img4=(ImageView)findViewById(R.id.bran);
     img4.setOnClickListener(this);
    
	
	c1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton v, boolean flag) {
				if(v.isChecked()){
					a=1;
					showDialog(CUSTOM_DIALOG);
				
				}
			else{
				a=1;
				if(value!=0)
				{
				remove();
				
				GlobalData.price.remove("Rs. "+y);
				GlobalData.i.remove(""+x);
				GlobalData.items.remove("018Home");
				 update(value);
				
			}
			}
			}
	});
	
c2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		
		public void onCheckedChanged(CompoundButton v, boolean flag) {
			
			if(v.isChecked()){
				a=2;
				showDialog(CUSTOM_DIALOG);
			}
			
			else{
				a=2;
				if(value!=0)
				{
				remove();
				GlobalData.price.remove("Rs. "+y);
				GlobalData.i.remove(""+x);
				GlobalData.items.remove("Elcooker");
				update(value);
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
			if(value!=0)
			{
			remove();
			GlobalData.price.remove("Rs. "+y);
			GlobalData.i.remove(""+x);
			GlobalData.items.remove("cooker 80");
			update(value);
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
			if(value!=0)
			{
			remove();
			GlobalData.price.remove("Rs. "+y);
			GlobalData.i.remove(""+x);
			GlobalData.items.remove("Homem");
			update(value);
		}
		}
		}
});

TextView t3=(TextView)findViewById(R.id.detail3);

//t3.setOnClickListener(this);
TextView t5=(TextView)findViewById(R.id.detail5);

//t5.setOnClickListener(this);
Button bnv1=(Button)findViewById(R.id.btnv1);
bnv1.setOnClickListener(this);
Button bnv2=(Button)findViewById(R.id.btnv2);
//bnv2.setOnClickListener(this);
	}


public void onClick(View v) {
	
//	if(v.getId()==R.id.detail3){
//		
//		call(GlobalData.ph_num1);
//	}
//	else if(v.getId()==R.id.detail5){
//		
//		call(GlobalData.ph_num2);
//	}

	 if(v.getId()==R.id.btnv2){
		Intent vin=new Intent(this,fourth.class);
		//vin.putExtra("key", num2);
		startActivity(vin);
		
	}
	else if(v.getId()==R.id.btnv1){
		Intent vin1=new Intent(this,fifth.class);
		Intent putExtra = vin1.putExtra("key",value_for_fifth);
		startActivity(vin1);
	}
	 if(v.getId()==R.id.apl){
			Intent vin=new Intent(this,fourth.class);
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
	
	switch(id){
	case 1:
		
		 dialog = new Dialog(this);

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
		qanv1.setText(s);
		
		value=value+quantity*3295;
		x=quantity;
		
		GlobalData.i.add(""+s);
		y=quantity*3295;
		GlobalData.price.add("Rs. "+y);
		Toast.makeText(getApplicationContext(), s, 4000).show();
		GlobalData.items.add("018Home");
		
		 update(value);
		
		 break;
	case 2:
		quantity=Integer.parseInt(s);
		qanv2.setText(s);
		x=quantity;
		value=value+quantity*2340;
		GlobalData.i.add(""+s);
		GlobalData.items.add("Elcooker");
		y=quantity*2340;
		GlobalData.price.add("Rs. "+y);
		 
		 update(value);
		break;
	case 3:
		quantity=Integer.parseInt(s);
		qanv3.setText(s);
		GlobalData.i.add(""+s);
		x=quantity;
		value=value+quantity*4450;
		y=quantity*4450;
		GlobalData.price.add("Rs. "+y);
		GlobalData.items.add("cooker 80");
		update(value);
		break;
	case 4:
		quantity=Integer.parseInt(s);
		qanv4.setText(s);
		GlobalData.i.add(""+s);
		value=value+quantity*4395;
		x=quantity;
		y=quantity*4395;
		GlobalData.price.add("Rs. "+y);
		GlobalData.items.add("Homem");
		 update(value);
		break;
	}
	
}
private void remove(){
	switch(a){
	case 1:
		 quant=qanv1.getText().toString();
		 quanti=Integer.parseInt(quant);
		 
		value=value-(quanti)*3295;
		qanv1.setText("1");
		break;
	case 2:
	 quant=qanv2.getText().toString();
		 quanti=Integer.parseInt(quant);
		value=value-(quanti)*2340;
		qanv2.setText("1");
		break;
	case 3:
		quant=qanv3.getText().toString();
		 quanti=Integer.parseInt(quant);
		value=value-(quanti)*4450;
		qanv3.setText("1");
		break;
	case 4:
		quant=qanv4.getText().toString();
		 quanti=Integer.parseInt(quant);
		value=value-(quanti)*4395;
		qanv4.setText("1");
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
   private void move(){
	   Intent in =new Intent(getApplicationContext(), RelianceActivity.class);
	   startActivity(in);
}

private void update(int Amount){
	 GlobalData.page_3_value=Amount+GlobalData.page_4_value+GlobalData.page_5_value+GlobalData.page_6_value;
	TextView r5=(TextView)findViewById(R.id.rate5);
	r5.setText("RS. "+GlobalData.page_3_value+"/-");
	value_for_fifth=GlobalData.page_3_value;
}
private void call(String x){
	
	Intent DialIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+x));
	 startActivity(DialIntent);
}



	
}
	
			
		
	

		
		
		
	
	
	
	
	
	
	
		
		
	

	
		
	
	

