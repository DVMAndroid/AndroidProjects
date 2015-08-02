package com.example.android_menus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ContextMenu extends Activity {

	Button context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		
		context=(Button) findViewById(R.id.button);
		
		context.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				registerForContextMenu(context);
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity__menu, menu);
		
		return super.onCreateOptionsMenu(menu);
		
	}
@Override
public void onCreateContextMenu(android.view.ContextMenu menu, View v,
		ContextMenuInfo menuInfo) {
	// TODO Auto-generated method stub
	super.onCreateContextMenu(menu, v, menuInfo);
	
	getMenuInflater().inflate(R.menu.context_menu, menu);
	
	menu.setHeaderTitle("Context Menu");
}

@Override
public boolean onContextItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	super.onContextItemSelected(item);
	if(item.getItemId()==R.id.action_settings)
	{
		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();

	}
	if(item.getItemId()==R.id.veg)
	{
		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();

	}
	if(item.getItemId()==R.id.non)
	{
		Toast.makeText(getApplicationContext(), ""+item.getTitle().toString(), 3000).show();

	}
	return true;
	
	
	
}
}
