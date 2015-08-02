package com.example.spinnerandautocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {

	
	Spinner spinner;
	AutoCompleteTextView autocomp;
	public String[] names={"one","ontario","two","three","four","five","six","seven","eight","nen","ten"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //This is for SpinnerView
        
        setContentView(R.layout.activity_main);
        
        spinner=(Spinner) findViewById(R.id.spinner);
        
        
        spinner.setAdapter(new myspinner());
        
        spinner.setOnItemSelectedListener(this);
        
        
     /*   spinner.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
        */
        
        
        
 //This is for autocompletetextview
        
     /*   setContentView(R.layout.autocompletetextview);
        
        autocomp=(AutoCompleteTextView) findViewById(R.id.auto);
        
       ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_checked,names);
       
       autocomp.setThreshold(1);
       autocomp.setAdapter(adapter);
       */
       

    }


   
    
    
    
   public class myspinner extends BaseAdapter
   {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View v, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		LayoutInflater inf=getLayoutInflater();
		
		v=inf.inflate(R.layout.spinnerxml, null);
		
		TextView text=(TextView)v.findViewById(R.id.text);
		
		text.setText(names[arg0]);
		return v;
	}
	   
   }
   
   
   @Override
   public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
     long arg3) {
    // TODO Auto-generated method stub
    int item=spinner.getSelectedItemPosition();
    Toast.makeText(getApplicationContext(), "selected items is:"+names[item],3000).show();
   }
   @Override
   public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub
   }

    
}
