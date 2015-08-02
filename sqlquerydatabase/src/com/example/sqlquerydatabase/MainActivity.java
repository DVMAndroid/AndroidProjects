package com.example.sqlquerydatabase;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		result=(TextView) findViewById(R.id.result);
		
		
SQLiteDatabase database=openOrCreateDatabase("Android", MODE_PRIVATE, null);
		
		database.execSQL("CREATE TABLE employees1(FirstName VARCHAR(20),LastName VARCHAR(20),Age Int(10));");
		
		//database.execSQL("INSERT INTO employee1(FirstName,LastName,Age) VALUES('android','eclipse','5')");
		database.execSQL("INSERT INTO employees1(FirstName,LastName,Age) VALUES('java','notepad','50')");
		
		//database.execSQL("DELETE FROM employee1 WHERE FirstName='java';");
		
		//database.execSQL("UPDATE  employee1 SET FirstName='raghu' WHERE Age='5';");
		
		Cursor c=database.rawQuery("SELECT * FROM employees1", null);
		
		c.moveToFirst();
		
		String s=c.getString(c.getColumnIndex("FirstName"));
		String ss=c.getString(c.getColumnIndex("LastName"));
		String sss=c.getString(c.getColumnIndex("Age"));
		
result.setText("FirstName:"+s+"LastName:"+ss+"Age:"+sss);		
}

	

}
