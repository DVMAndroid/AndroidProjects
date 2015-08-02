package com.mahesh.inspire;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Shopping_Splash extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spl);
        Runnable th_work=new Runnable() {
			
    		
			public void run() {
				// TODO Auto-generated method stub
			try{
				Thread.sleep(4000);
		Intent i=new Intent(getApplicationContext(), RelianceActivity.class);
			startActivity(i);
			}
			catch(Exception ex)
			{
				
			}
			}
		};
		
		new Thread(th_work).start();
    }
    public void onresume()
    {
Runnable th_work=new Runnable() {
			
    		
			public void run() {
				// TODO Auto-generated method stub
			try{
				Thread.sleep(4000);
		Intent i=new Intent(getApplicationContext(), RelianceActivity.class);
			startActivity(i);
			}
			catch(Exception ex)
			{
				
			}
			}
		};
		
		new Thread(th_work).start();
    }

}