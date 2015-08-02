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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.mahesh.advance.XmlHandler.HanldlerImple;
import com.mahesh.advance.utils.BranchDetailss;

public class Branch extends ListActivity {

	ListView lv;
	BranchDetailss b1;
static String lat;
static String lang;

	public static List<BranchDetailss> bDetails = new ArrayList<BranchDetailss>();
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new HttpTask().execute();
	}

	public class HttpTask extends AsyncTask<Void, Void, Void> {
		ProgressDialog pd;

		protected void onPreExecute() {

			pd = ProgressDialog.show(Branch.this, "Please Wait",
					"Connecting To Server");

			pd.setCancelable(true);

		}

		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			try {

				//URL rssUrl = new URL(
					//	"http://192.168.0.102:9090/studentdetails.xml");

				SAXParserFactory mySAXParserFactory = SAXParserFactory
						.newInstance();

				SAXParser mySAXParser = mySAXParserFactory.newSAXParser();

				XMLReader myXMLReader = mySAXParser.getXMLReader();

				HanldlerImple myRSSHandler = new HanldlerImple();

				myXMLReader.setContentHandler(myRSSHandler);
				

		           InputStream istream = null;
		           istream =  getApplicationContext().getResources().openRawResource(R.raw.branchdetail);
					

				//InputSource myInputSource = new InputSource(rssUrl.openStream());

				//myXMLReader.parse(myInputSource);
				myXMLReader.parse(new InputSource(istream));

		      
				bDetails= myRSSHandler.getsDetails();
				
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
			return bDetails.size();
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
			LayoutInflater vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.bdetails, null);

			TextView Bname = (TextView) v.findViewById(R.id.Bname);
			TextView Address1 = (TextView) v.findViewById(R.id.Address1);
			TextView Address2 = (TextView) v.findViewById(R.id.Address2);
			TextView Address3 = (TextView) v.findViewById(R.id.Address3);
			TextView Contact= (TextView) v.findViewById(R.id.Contact);
			TextView location=(TextView)v.findViewById(R.id.location);
			
			BranchDetailss data = bDetails.get(position);

		
			
			Bname.setText(data.getBname());
			Address1.setText(data.getAddress1());
			Address2.setText(data.getAddress2());
			Address3.setText(data.getAddress3());
			Contact.setText(data.getContact());
            location.setText(data.getlocation());
          
			return v;
		}
    }
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		BranchDetailss b1=null;
		switch(position){
		case 1:
			b1=bDetails.get(position);
			lat=b1.getlat();
			lang=b1.getlang();
			break;
		case 2:
			b1=bDetails.get(position);
			lat=b1.getlat();
			lang=b1.getlang();
			break;
		case 3:
			b1=bDetails.get(position);
			lat=b1.getlat();
			lang=b1.getlang();
			break;
		case 4:
			b1=bDetails.get(position);
			lat=b1.getlat();
			lang=b1.getlang();
			break;
		case 5:
			b1=bDetails.get(position);
			lat=b1.getlat();
			lang=b1.getlang();
			break;
		
		}
		
		
	
		Toast.makeText(getApplicationContext(), "List of events", Toast.LENGTH_SHORT).show();
	
		startActivity(new Intent(getApplicationContext(),mainone.class));
	}
	

}