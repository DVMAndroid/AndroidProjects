package com.example.pullparserexample;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

public class MainActivity extends Activity {
	     
	    private static final String xmlUrl =
		        "http://dl.dropbox.com/u/7215751/JavaCodeGeeks/AndroidFullAppTutorialPart03/Transformers+2007.xml";
	    
	    private final String TAG = getClass().getSimpleName();
	    boolean sc=false;
		     
		    @SuppressLint("NewApi")
			@Override
		    public void onCreate(Bundle savedInstanceState) {
		     
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_main);  
		        
		        
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        
		        
		        try {
		            parseFromUrl();
		        }
		        catch (Exception e) {
		            Log.e(TAG, "Error while parsing", e);
		        }
		         
		    }
		     
		    private void parseFromUrl() throws Exception {
		         
		        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		        factory.setNamespaceAware(false);
		        XmlPullParser xpp = factory.newPullParser();
		         
		        URL url = new URL(xmlUrl);
		        URLConnection ucon = url.openConnection();
		        InputStream is = ucon.getInputStream();
		         
		        xpp.setInput(is, null);
		         
		        Log.v("Response XML Data:",""+is.toString());
		        
		        int eventType = xpp.getEventType();
		         
		        while (eventType != XmlPullParser.END_DOCUMENT) {
		             
		            if (eventType == XmlPullParser.START_DOCUMENT) {
		                Log.d(TAG, "Start document");
		            }
		            else if (eventType == XmlPullParser.END_DOCUMENT) {
		                Log.d(TAG, "End document");
		            }
		            else if (eventType == XmlPullParser.START_TAG) {
		            	
		            	if(getComponentName().equals("score"))
		            	{
		            		sc=true;
		            	}
		                Log.d(TAG, "Start tag " + xpp.getName());
		            }
		            else if (eventType == XmlPullParser.END_TAG) {
		                Log.d(TAG, "End tag " + xpp.getName());
		                if(getComponentName().equals("score"))
		            	{
		                	sc=false;
		            	}
		            }
		            else if (eventType == XmlPullParser.TEXT) {
	                Log.d(TAG, "Text " + xpp.getText());
		            }
		             
		            eventType = xpp.next();
		             
		        }
	         
		    }
}
