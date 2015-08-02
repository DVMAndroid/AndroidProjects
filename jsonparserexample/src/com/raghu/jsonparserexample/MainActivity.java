package com.raghu.jsonparserexample;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	JSONArray response;
	private static final String TAG_SUCCESS = "success";
	private static String url_create_product = "http://api.androidhive.info/contacts/";

	ArrayList<String> aa=new ArrayList<String>();
	TextView res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		res=(TextView) findViewById(R.id.response);
		
		
		
		new CreateNewProduct().execute();
		
		
		
		
	}

	/**
	 * Background Async Task to Create new product
	 * */
	class CreateNewProduct extends AsyncTask<String, String, String> {



		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Please Wait..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.setCanceledOnTouchOutside(false);
			pDialog.show();
		}

		
		/**
		 * Creating product
		 * */
		protected String doInBackground(String... args) {
			try {
				
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				//params.add(new BasicNameValuePair("", ""));
				
				// getting JSON Object
				// Note that create product url accepts POST method
				JSONObject json = jsonParser.makeHttpRequest(url_create_product,
						"POST", params);
				JSONObject jsonone = jsonParser.makeHttpRequest(url_create_product,
						"GET", params);
				// check log cat fro response
				//	Log.d("Create Response", json.toString());

				// check for success tag      

				
					// failed to create product

					response= json.getJSONArray("contacts");

					// looping through All Products
					for (int i = 0; i < response.length(); i++) {
						JSONObject c = response.getJSONObject(i);

						String id=c.getString("id");
                        String name=c.getString("name");
						
                        aa.add(id);
                        aa.add(name);
                    
						Log.v("Response:",""+aa);
					}

					
					//res.setText(""+aa.toString());
				
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
			
		}

	}
}
