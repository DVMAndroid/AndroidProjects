package com.example.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {


	WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		web=(WebView) findViewById(R.id.webview);


		//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		//        NetworkInfo ni = cm.getActiveNetworkInfo();
		//        if (ni!=null && ni.isAvailable() && ni.isConnected()) {
		//            return true;
		//        } else {
		//            return false; 
		//        }


		try {
			ConnectivityManager cn=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo nf=cn.getActiveNetworkInfo();
			if(nf != null && nf.isConnected()==true )
			{
				web.loadUrl("https://dl.dropboxusercontent.com/u/348446/trainings/android.html");
				Toast.makeText(this, "Network Available", Toast.LENGTH_LONG).show();

			}
			else
			{
				AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);

				alert.setMessage("Please Check your internet connnection");
				alert.show();
				Toast.makeText(this, "Network Not Available", Toast.LENGTH_LONG).show();

			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.v("Exception:",""+e);
		}
		
		
		
	}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

}
