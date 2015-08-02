package com.example.android_menus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


/*
 * 
               The Options Menu will launches when the user clicks menu button in android.
Steps to create OptionMenu:
1.Create a project and name it as OptionsMenu
2.under res folder create new folder and name it as menu
3.under menu folder create items.xml file and create some items what i'm giving below
4.In java file write the code for options menu you can see java code below

 */
public class Activity_Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	
    	if(item.getItemId()==R.id.action_settings)
    	{
    		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();
    	}
    	if(item.getItemId()==R.id.msg)
    	{
    		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();
	
    	}
    	if(item.getItemId()==R.id.call)
    	{
    		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();

    	}
    	
    	
    	return super.onOptionsItemSelected(item);
    	
    }
    
}
