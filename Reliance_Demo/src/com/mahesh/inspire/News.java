package com.mahesh.inspire;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.mahesh.advance.XmlHandler.handlertwo;
import com.mahesh.advance.utils.NewsDetailss;


public class News extends ListActivity {

	ListView lv;
	public static List<NewsDetailss> nDetails = new ArrayList<NewsDetailss>();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		new HttpTask().execute();
	}

	public class HttpTask extends AsyncTask<Void, Void, Void> {
		ProgressDialog pd;

		protected void onPreExecute() {

			//sDetails.clear();

			pd = ProgressDialog.show(News.this, "Please Wait",
					"Connecting To Server");

			pd.setCancelable(true);

		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			try {

				//URL rssUrl = new URL(
					//	"http://192.168.0.102:9090/studentdetails.xml");

				SAXParserFactory mySAXParserFactory = SAXParserFactory
						.newInstance();

				SAXParser mySAXParser = mySAXParserFactory.newSAXParser();

				XMLReader myXMLReader = mySAXParser.getXMLReader();

				handlertwo myRSSHandler = new handlertwo();

				myXMLReader.setContentHandler(myRSSHandler);
				

		           InputStream istream = null;
		      istream =  getApplicationContext().getResources().openRawResource(R.raw.newsdetails);
					

				//InputSource myInputSource = new InputSource(rssUrl.openStream());

				//myXMLReader.parse(myInputSource);
				myXMLReader.parse(new InputSource(istream));

		      
				nDetails = myRSSHandler.getnDetails();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return null;
		}

		protected void onPostExecute(Void unused) {
			Log.v("on post execute", "post execute+++");

			pd.dismiss();
			//lv.setAdapter(new StdentAdapter());
			setListAdapter(new StdentAdapter());
		}

	}
	public class StdentAdapter extends BaseAdapter {

		public int getCount() {
			// TODO Auto-generated method stub
			return nDetails.size();
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			View v = null;
			// LinearLayout ll = new LinearLayout(mContext);
			// LayoutParams lp;

			LayoutInflater vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.ndetails, null);

			TextView Nproduct = (TextView) v.findViewById(R.id.Nproduct);
			TextView Info = (TextView) v.findViewById(R.id.Info);
			

			NewsDetailss data = nDetails.get(position);
			
			Nproduct.setText(data.getNproduct());
			Info.setText(data.getInfo());
			
			return v;
		}
	}

	


    }
