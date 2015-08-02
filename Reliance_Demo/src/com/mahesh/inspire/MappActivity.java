package com.mahesh.inspire;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MappActivity extends Activity {
	private static final String TAG = "mymaps";

    /** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map);

    Button map0 = (Button)findViewById(R.id.icon6);
    
    final String goMap = "http://maps.google.com/maps?f=d&hl=en&saddr=17.4628,78.3492&daddr=17.4628,78.3492&ie=UTF8&0&om=0&output=kml";
            final Uri url = Uri.parse(goMap);
            map0.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {

                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                            intent.addCategory("android.intent.category.LAUNCHER");
                         
                            intent.setData(url);
                            startActivity(intent);

                    }
                    
                   
    });             
}


}