package com.example.dialogs;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button alert,custom,progress,time,date;

	///Custom dialog widgets

	EditText dedit;
	Button dbutton;
	Dialog d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		alert=(Button) findViewById(R.id.alert);
		custom=(Button) findViewById(R.id.custom);
		progress=(Button) findViewById(R.id.progress);
		time=(Button) findViewById(R.id.time);
		date=(Button) findViewById(R.id.date);


		alert.setOnClickListener(new mybutton());
		custom.setOnClickListener(new mybutton());

		progress.setOnClickListener(new mybutton());
		time.setOnClickListener(new mybutton());
		date.setOnClickListener(new mybutton());

	}

	public class mybutton implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			if(v.getId()==R.id.alert)
			{

				AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
				a.setTitle("This is alert dialog");

				a.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "cancel",3000).show();
					}
				});
				a.setNegativeButton("OK",new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "ok",3000).show();

					}
				});
				a.show();


			}
			if(v.getId()==R.id.custom)
			{

				d=new Dialog(MainActivity.this);
				d.setTitle("This custom dialog");
				d.setContentView(R.layout.customdialog);

				dedit=(EditText)d.findViewById(R.id.dedit);
				dbutton=(Button) d.findViewById(R.id.dbutton);

				dbutton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						String s=dedit.getText().toString();
						Toast.makeText(MainActivity.this,s,3000).show();
						d.dismiss();
					}
				});



				d.show();


			}
			if(v.getId()==R.id.progress)
			{

				ProgressDialog pd=new ProgressDialog(MainActivity.this);
				pd.setMessage("Please Wait......");
				pd.setMax(1000);
				pd.setCanceledOnTouchOutside(false);
				pd.show();


			}
			if(v.getId()==R.id.time)
			{
				Calendar c=Calendar.getInstance();
				int hh=	c.get(Calendar.HOUR);
				int mm=c.get(Calendar.MINUTE);


				TimePickerDialog time=new TimePickerDialog(MainActivity.this,null, hh,mm,true);
				time.show();
			}
			if(v.getId()==R.id.date)
			{

				Calendar cd=Calendar.getInstance();
				int dd=cd.get(Calendar.DATE);
				int mm=cd.get(Calendar.MONTH);
				int yy=cd.get(Calendar.YEAR);

				
				DatePickerDialog date=new DatePickerDialog(MainActivity.this, null, yy, mm, dd);
				date.show();
				
				
				
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
