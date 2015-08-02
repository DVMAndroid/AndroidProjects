package com.mahesh.inspire;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;





import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class Webservice extends ListActivity {

	
	public static  List<AreaDetails> sDetails = new ArrayList<AreaDetails>();
ListView lv;
int CUSTOM_DIALOG=1;
//EditText edt,edt1;
Uri url;
private TextView edt,edt1;
private static String Destination,Source;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		lv=getListView();
		new HttpTask().execute();
	}

	public class HttpTask extends AsyncTask<Void, Void, Void> {
		ProgressDialog pd;

		protected void onPreExecute() {
			pd = ProgressDialog.show(Webservice.this, "Please Wait",
					"Connecting To Server");

			pd.setCancelable(true);

		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			try {

				//URL rssUrl = new URL(
					//	"http://192.168.0.102:9090/studentdetails.xml");

				SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();

				SAXParser mySAXParser = mySAXParserFactory.newSAXParser();

				XMLReader myXMLReader = mySAXParser.getXMLReader();

				Student Handler = new Student();

				myXMLReader.setContentHandler(Handler);
				

		           InputStream istream = null;
		      istream =  getApplicationContext().getResources().openRawResource(R.raw.studentdetail);
				//InputSource myInputSource = new InputSource(rssUrl.openStream());
			//	myXMLReader.parse(myInputSource);
			myXMLReader.parse(new InputSource(istream));

		      
				sDetails = Handler.getSDetails();
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return null;
		}

		protected void onPostExecute(Void unused) {
			Log.v("on post execute", "post execute+++");

			pd.dismiss();
			
			lv.setAdapter(new StdentAdapter());
			
		}

	}
	public class StdentAdapter extends BaseAdapter  {

		public int getCount() {
			// TODO Auto-generated method stub
			
			return sDetails.size();
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

			View v = convertView;
			// LinearLayout ll = new LinearLayout(mContext);
			// LayoutParams lp;
			if (v == null) {
			LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.details, null);
			}
			TextView ar = (TextView) v.findViewById(R.id.ar);
			TextView ct = (TextView) v.findViewById(R.id.ct);
			AreaDetails data = sDetails.get(position);
			ar.setText(data.getArea());
			ct.setText(data.getCity());			
			return v;
		}
	}
		protected void onListItemClick(ListView l, View v, int position, long id) {
			showDialog (CUSTOM_DIALOG);
			AreaDetails a1=sDetails.get(position);
			 edt1.setText(""+a1.getArea()+","+a1.getCity());
		}
		protected Dialog onCreateDialog(int id){
			// TODO Auto-generated method stub
			 final Dialog dialog = new Dialog(Webservice.this);
	         dialog.setContentView(R.layout.dialog);
	         dialog.show();
	         dialog.setTitle("     MAP         ");
			//return dialog;
			    edt = (EditText) dialog.findViewById(R.id.edt);
			    edt1 = (EditText) dialog.findViewById(R.id.edt1);
		         Button b1 = (Button) dialog.findViewById(R.id.btn3);
		         b1.setOnClickListener(new OnClickListener() {
		             public void onClick(View v) {
		            	 checkAddress();
                         final String gg="http://maps.google.com/maps?f=d&hl=en&saddr=";
         		        String gg1="&daddr=";
         		        
         		        String gg4="&ie=UTF8&0&om=0&output=kml";
         		        String gg3=gg+Destination+gg1+Source+gg4;
         		        url = Uri.parse(gg3);
         		    Intent intent = new Intent("android.intent.action.VIEW");
                     intent.setComponent(ComponentName.unflattenFromString("com.google.android.apps.maps/com.google.android.maps.MapsActivity"));
                      intent.addCategory("android.intent.category.LAUNCHER");
                      intent.setData(url);
                      startActivity(intent);	
                    //  Destination=null;
                      //edt=null;
		            	edt.setText(""); 
		             }
		         });
		         
		         return dialog;
		             }
		 void checkAddress()
         {
			 Geocoder geoCoder = new Geocoder(Webservice.this, Locale.getDefault());

                 Destination = edt1.getText().toString();
                 Source=edt.getText().toString();
               /*  double i=Double.parseDouble(DestinationAddress);
                 double j=Double.parseDouble(vv);*/
                 List<Address> addressList = null;
                 List<Address> addressList1 = null;
                 try {
                         addressList = geoCoder.getFromLocationName(Destination, 1);
                         addressList1 = geoCoder.getFromLocationName(Source, 1);
                         
//                         List<Address> s= geoCoder.getFromLocation(i, j, 10);
                 
                 if(addressList.isEmpty())
                 {
                         AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Webservice.this);  
                         dlgAlert.setMessage("Location not found!!! Please change address and try again."); 
                         dlgAlert.setTitle(" GeocodeActivity "); 
                         dlgAlert.setPositiveButton("OK", null); 
                         dlgAlert.setCancelable(true); 
                         dlgAlert.create().show(); 
                         edt1.requestFocus();
                 }
                else
                 {
                 Address address = addressList.get(0);
                 Address a=addressList1.get(0);
                 if(address.hasLatitude() && address.hasLongitude()){
                         
                         Toast.makeText(Webservice.this,"Address : "+address.getAddressLine(0)+"\nCountry : "+address.getCountryName()+"\nLatitute : "+address.getLatitude()+"\nLongitute : "+address.getLongitude(),Toast.LENGTH_LONG).show();
                         Toast.makeText(Webservice.this,"Address : "+a.getAddressLine(0)+"\nCountry : "+a.getCountryName()+"\nLatitute : "+a.getLatitude()+"\nLongitute : "+a.getLongitude(),Toast.LENGTH_LONG).show();
                         
                 }}
                 }catch (IOException e) {
                     Toast.makeText(Webservice.this,"Location not found!!! Please change address and try again."+addressList,Toast.LENGTH_SHORT).show();
//                     Toast.makeText(Geocode.this,"Location not found!!! Please change address and try again."+i,Toast.LENGTH_SHORT).show();
                     e.printStackTrace();
             }
         }

		
		
		
		
	}

	


	

