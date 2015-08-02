package com.example.listviews;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	
	String[] names={"A","B","C","D","E","F","G","H","I"};
	int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
			R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
			R.drawable.ic_launcher,R.drawable.ic_launcher};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        
//        ListView list=(ListView) findViewById(R.id.listview);
//        
        
        /*Array Adapter */
        
//        ArrayAdapter<String> ada=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,names);
//        
//        list.setAdapter(ada);
//        
//        
//        list.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				
//				Toast.makeText(getApplicationContext(), ""+arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
//				
//				if(arg2==0)
//				{
//					/// create intent to forward to next class
//				}
//				
//			}
//		});
        
        
        
        //BaseAdapter 
        
        
        
      //  list.setAdapter(new myadapter());
        
        setListAdapter(new myadapter());
    }

public class myadapter extends BaseAdapter
{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return images.length;
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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		//we can't use setcontentview method here thats we are using layout inflater...
		
		LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		
		arg1=inflater.inflate(R.layout.baseadapterlayout, null);
		
		ImageView image=(ImageView)arg1. findViewById(R.id.image);
		
		TextView text=(TextView)arg1. findViewById(R.id.textview);
		
		image.setBackgroundResource(images[arg0]);
		
		text.setText(""+names[arg0]);		
		return arg1;
	}
	
}
  
    
}
