package com.example.gridview;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class MainActivity extends Activity {

	public String[] names={"one","two","three","four","five","six","seven","eight","nen","ten"};
	
	public int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
			R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	
	GridView grid;
	@SuppressWarnings("deprecation")
	Gallery gallery;
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //This is for grid view 
        /*
        setContentView(R.layout.activity_main);
        grid=(GridView) findViewById(R.id.grid);
        
         grid.setAdapter(new myadapter());
        */
        
        //This is for gallery view
       setContentView(R.layout.galleryview);
       gallery=(Gallery) findViewById(R.id.gallery);
       gallery.setAdapter(new mygalleryadapter());
        
    }

    public class mygalleryadapter extends BaseAdapter
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
		public View getView(int arg0, View v, ViewGroup arg2) {
			// TODO Auto-generated method stub
			LayoutInflater inf=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			v=inf.inflate(R.layout.gallerylayout, null);
			
			ImageView img=(ImageView)v.findViewById(R.id.image);
			img.setBackgroundResource(images[arg0]);
			  img.setScaleType(ScaleType.FIT_XY);
			  // img.setLayoutParams(new Gallery.LayoutParams(400, 400));
			return v;
		}
    	
    }

  public class myadapter extends BaseAdapter
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
		
		//LayoutInflater inf=getLayoutInflater();
		
		LayoutInflater inf=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		
		v=inf.inflate(R.layout.gridlayout, null);
		
		ImageView img=(ImageView)v.findViewById(R.id.image);
		
		TextView text=(TextView)v.findViewById(R.id.textview);
		
		img.setBackgroundResource(images[arg0]);
		
		text.setText(names[arg0]);
		
		
		return v;
	}
	  
  }
    
}
