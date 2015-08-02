package com.mahesh.inspire;




import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AndroidTabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
        TabHost tabHost = getTabHost();
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Photos");
        photospec.setIndicator("Nearest", getResources().getDrawable(R.drawable.icon_photos_tab));
        Intent photosIntent = new Intent(this, Reliance.class);
       photospec.setContent(photosIntent);
      
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("Songs");
        // setting Title and Icon for the Tab
        songspec.setIndicator("MapView", getResources().getDrawable(R.drawable.icon_songs_tab));
        Intent songsIntent = new Intent(this, Webservice.class);
        songspec.setContent(songsIntent);
        
        // Tab for Videos
       
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
       
    }
}