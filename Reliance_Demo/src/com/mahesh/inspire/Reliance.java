package com.mahesh.inspire;

import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;



public class Reliance extends  Activity {
	private ListView lv;
	static String d;
	public static List<String> sDetails = new ArrayList<String>();
	
	 public static List<String> getDetails() {
		return sDetails;
	}

	public static void setsDetails(List<String> sDetails) {
		Reliance.sDetails = sDetails;
	}

	public static String[] are = 
	        {
		 
	                "Hitechcity",   
	                "Banjarahills",
	                "Jublihills",       
	                "Ameerpet",
	                "kukatPalli",
	                "Secunderabad",  
	                "Kothaguda"
	               	        };
		 public String[] city = 
	        {
				   "Hyderabad",   
	                "Hyderabad",
	                "Hyderabad",       
	                "Hyderabad",
	                "Hyderabad",
	                "Hyderabad",  
	                "Hyderabad"
	               
	        };
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	lv.setBackgroundColor(Color.WHITE);
		setContentView(R.layout.main1);
		lv=(ListView)findViewById(R.id.lv);
	       lv.setAdapter(new BranchesListAdapter(this));
	}
	 		
	public class BranchesListAdapter extends BaseAdapter {
		 private Context mContext;	

		        public BranchesListAdapter(Context context) {
		            mContext = context;
		            
		        }
		        
		public int getCount() {
			// TODO Auto-generated method stub
			 return are.length;
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
        	if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              v = vi.inflate(R.layout.main2, null);
        	}
			TextView area = (TextView)v.findViewById(R.id.area);
			TextView area1 = (TextView)v.findViewById(R.id.area1);
//			TextView map = (TextView)v.findViewById(R.id.map);
//			map.setTag(position);
//            map.setOnClickListener(this);
            
//			Log.v("Data",are[position]);
//			Log.v("Data",city[position]);
			area.setText(are[position]);
        	area1.setText(city[position]);
			return v;
		}

		protected void onListItemClick(ListView l, View v, int position, long id) {

		}
		
	}
}
	


	

