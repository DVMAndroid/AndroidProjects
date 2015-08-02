package com.example.mediaplayer;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController.MediaPlayerControl;

@SuppressWarnings("unused")
public class MainActivity extends Activity implements OnPreparedListener {

	
	Button start,stop;
    MediaPlayer player;
    MediaPlayer mp;
    @SuppressWarnings("static-access")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
       
        
        
        MediaPlayer mp=new MediaPlayer();  
        try{  
          //  mp.setDataSource("/sdcard/Music/maine.mp3");//Write your location here 
        	
        	/*mp.create(getApplicationContext(), R.raw.old);
            
    
         //  mp.setDataSource("http://.../movie.mp4");
            mp.setOnPreparedListener(this);
            mp.prepareAsync();
            mp.start();
            */
        	
        	MediaPlayer mPlayer2= MediaPlayer.create(this, R.raw.old);
             mPlayer2.start();
              
        }catch(Exception e){e.printStackTrace();}  
          
        
        
        
        start=(Button) findViewById(R.id.start);
        stop=(Button) findViewById(R.id.stop);
        
        
        start.setOnClickListener(new mybutton());
        
        
      player=new MediaPlayer();
        
     //   mp.create(this, R.raw.bang);
       
        player.setLooping(true);
       
        
       
    }


   public class mybutton implements OnClickListener
   {

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getId()==R.id.start)
		{
			try {
				//player.setDataSource(getApplicationContext(), Uri.parse(""));
				
				player.create(MainActivity.this,R.raw.test);
				player.prepareAsync();
				player.start();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				Log.v("Exception:", ""+e);
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				Log.v("Exception:", ""+e);
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				Log.v("Exception:", ""+e);
				e.printStackTrace();
			} 
		}
		if(arg0.getId()==R.id.stop)
		{
			
		}
		
		
	}
	   
   }


@Override
public void onPrepared(MediaPlayer arg0) {
	// TODO Auto-generated method stub
	
}
    
}
