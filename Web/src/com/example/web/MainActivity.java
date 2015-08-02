package com.example.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.inspire.details.details;
import com.inspire.handler.Handle;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	
	public static List<details> d=new ArrayList<details>();
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		new httptask().execute();
		
	}

	public class httptask extends AsyncTask<Void, Void, Void>
	{

		public void onPreExecute()
		{
			super.onPreExecute();
			pd=new ProgressDialog(MainActivity.this);
			pd.setMessage("Please wait....");
			pd.setCanceledOnTouchOutside(false);
			pd.show();
			
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			
			try {
				URL rssUrl = new URL(
				"http://www.abbreviations.com/services/v1/abbr.aspx?tokenid=tk1184&term=word");
				SAXParserFactory mysaxparser=SAXParserFactory.newInstance();
				SAXParser parser=mysaxparser.newSAXParser();
				XMLReader reader=parser.getXMLReader();
				Handle han=new Handle();
				reader.setContentHandler(han);
				
				//For raw Resource
				//InputStream stream=null;
				//stream=getApplicationContext().getResources().openRawResource(R.raw.student);

				InputSource myInputSource = new InputSource(rssUrl.openStream());

			    reader.parse(myInputSource);
		//	reader.parse(new InputSource(stream));//For raw Resource
				d=han.getd();
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return null;
					
			
			
		
		
	}


		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
			setListAdapter(new student());
		}


		public class student extends BaseAdapter
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return d.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View v=null;
				LayoutInflater inflate=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
				v=inflate.inflate(R.layout.student, null);
				
				TextView txt1=(TextView)v.findViewById(R.id.textView1);
				TextView txt2=(TextView)v.findViewById(R.id.textView2);
				TextView txt3=(TextView)v.findViewById(R.id.textView3);
			//	TextView txt4=(TextView)v.findViewById(R.id.textView4);
				
				details data=d.get(position);
				
				txt1.setText(data.getSno());
				txt2.setText(data.getName());
				txt3.setText(data.getDesg());
				//txt4.setText(data.getEmail());
				
				return v;
			}
			
		}

	}
}
