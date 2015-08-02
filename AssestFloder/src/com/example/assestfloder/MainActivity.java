package com.example.assestfloder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView text=(TextView) findViewById(R.id.textview);
        
        AssetManager manager=getAssets();
        try {
		InputStream input=	manager.open("RAMADEVI INSURANCE.txt");
		 int size = input.available();
		           byte[] buffer = new byte[size];
		          input.read(buffer);
		           input.close();
		  
	          // byte buffer into a string
		          String s = new String(buffer);
		
		          text.setText(s);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
