package com.example.sharedprefrences;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText name,password;
	Button save,show,delete;
	SharedPreferences share;

	SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		name=(EditText) findViewById(R.id.name);
		password=(EditText) findViewById(R.id.password);

		save=(Button) findViewById(R.id.save);
		show=(Button) findViewById(R.id.show);
		delete=(Button) findViewById(R.id.delete);


		save.setOnClickListener(new mybutton());
		show.setOnClickListener(new mybutton());
		delete.setOnClickListener(new mybutton());
	}
	public class mybutton implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub

			String na=name.getText().toString();
			String ps=password.getText().toString();
			
			if(arg0.getId()==R.id.save)
			{
			share=getPreferences(MODE_PRIVATE);
			 editor=share.edit();
			editor.putString("user",na);
			editor.putString("pass", ps);
			editor.commit();
			
			}
			if(arg0.getId()==R.id.show)
			{
				share=getPreferences(MODE_PRIVATE);
				 editor=share.edit();
				String ss=share.getString("user","");
				String sss=share.getString("pass","");
				editor.commit();
				
		Toast.makeText(getApplicationContext(), "UserName:"+ss, 30000).show();
		Toast.makeText(getApplicationContext(), "Password:"+sss, 30000).show();
			
			}
			if(arg0.getId()==R.id.delete)
			{
				share=getPreferences(MODE_PRIVATE);
				 editor=share.edit();
				editor.remove("user");
				 
				// editor.clear();
				editor.commit();
			}
			
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
