package com.mahesh.inspire;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class mainone extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    
	public Button img1,img2,img3,img4,img5,img6; 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainone);
        
        img1=(Button)findViewById(R.id.icon1);
        img1.setOnClickListener(this);
        img2=(Button)findViewById(R.id.icon2);
        img2.setOnClickListener(this);
        img3=(Button)findViewById(R.id.icon3);
        img3.setOnClickListener(this);
        img4=(Button)findViewById(R.id.icon4);
        img4.setOnClickListener(this);
        img5=(Button)findViewById(R.id.icon5);
        img5.setOnClickListener(this);
        img6=(Button)findViewById(R.id.icon6);
        img6.setOnClickListener(this);
        
    }
    public void onClick(View v) {
    	

    	 if(v.getId()==R.id.icon1){
    			Intent vin=new Intent(this,about.class);
    			//vin.putExtra("key", num2);
    			startActivity(vin);
    			
    		}
    	 if(v.getId()==R.id.icon2){
    			Intent vin=new Intent(this,second.class);
    			//vin.putExtra("key", num2);
    			startActivity(vin);
    			
    		}
    	 if(v.getId()==R.id.icon3){
    			Intent vin=new Intent(this,News.class);
    			//vin.putExtra("key", num2);
    			startActivity(vin);
    			
    		}
    	 if(v.getId()==R.id.icon4){
    			Intent vin=new Intent(this,Branch.class);
    			//vin.putExtra("key", num2);
    			startActivity(vin);
    			
    		}
    	 if(v.getId()==R.id.icon5){
 			Intent vin=new Intent(this,contact.class);
 			//vin.putExtra("key", num2);
 			startActivity(vin);
 			
 		}
    	 if(v.getId()==R.id.icon6){
  			Intent vin=new Intent(this,AndroidTabLayoutActivity.class);
  			//vin.putExtra("key", num2);
  			startActivity(vin);
  			
  		}
 	
}
}