package com.example.database;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		textview=(TextView) findViewById(R.id.textview);
		
				
		
		SQLiteDatabase database=openOrCreateDatabase("Android",MODE_PRIVATE, null);
		
		//database.execSQL("CREATE TABLE employees1(FirstName VARCHAR(20),LastName VARCHAR(20),Age Int(10));");
		
		//database.execSQL("INSERT INTO employee1(FirstName,LastName,Age) VALUES('android','eclipse','5')");
		//database.execSQL("INSERT INTO employees1(FirstName,LastName,Age) VALUES('java','notepad','50')");
		
		//database.execSQL("DELETE FROM employee1 WHERE FirstName='java';");
		
		database.execSQL("UPDATE  employees1 SET FirstName='raghu' WHERE Age='50';");
		
		Cursor c=database.rawQuery("SELECT * FROM employees1", null);
		
		c.moveToFirst();
		
		String s=c.getString(c.getColumnIndex("FirstName"));
		String ss=c.getString(c.getColumnIndex("LastName"));
		String sss=c.getString(c.getColumnIndex("Age"));
		
		
		
		textview.setText("FN\n"+s+"LN\n"+ss+"AG\n"+sss);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
