package com.inspire.camara;

import java.util.ArrayList;
import java.util.Collections;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Demo1 extends Activity implements OnClickListener {
byte[] bb;
//Bundle b;
	
	ArrayList aa=new ArrayList();
	ArrayList aa1=new ArrayList();
	public static Bitmap bb1;
	 int j,w;
final ImagesAdapter im1=new ImagesAdapter(this);
	ImageView im;
	 static Bitmap bitmapsArray[]=new Bitmap[9];
	Boolean a=false;
	
	public static Bitmap[] getBb1() {
		return bitmapsArray;
	}
	public static void setBb1(Bitmap bb1) {
		Demo.bb1 = bb1;
	}
	public void onCreate(final Bundle b)
	{
		super.onCreate(b);
		
		setContentView(R.layout.gridlayout);
        GridView g = (GridView) findViewById(R.id.myGrid);
        Button ref=(Button)findViewById(R.id.refresh);
        Button cls=(Button)findViewById(R.id.Close);
        ref.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Demo1.class));
			}
		});
        cls.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Toast.makeText(getApplicationContext(), "haiii", 2000).show();
				finish();
			}
		});
        CameraDemo d=new CameraDemo();
		
		bb=d.getBitMap();
		bb1 = BitmapFactory.decodeByteArray(bb, 0, bb.length);
		Bitmap bMapScaled = Bitmap.createScaledBitmap(bb1, 240, 240, true);
		for(int i=0;i<bitmapsArray.length;i++){
			aa.add(i);
			aa1.add(i);
		}
		Collections.shuffle(aa);
		 bitmapsArray[(Integer)aa.get(0)] = Bitmap.createBitmap(bMapScaled, 0, 0, 80, 80);
		    bitmapsArray[(Integer)aa.get(1)] = Bitmap.createBitmap(bMapScaled, 80, 0, 80, 80);
		    bitmapsArray[(Integer)aa.get(2)] = Bitmap.createBitmap(bMapScaled, 160, 0, 80, 80);
		    bitmapsArray[(Integer)aa.get(3)] = Bitmap.createBitmap(bMapScaled, 0, 80, 80, 80);
		    bitmapsArray[(Integer)aa.get(4)] = Bitmap.createBitmap(bMapScaled, 80, 80, 80, 80);
		    bitmapsArray[(Integer)aa.get(5)] = Bitmap.createBitmap(bMapScaled, 160, 80, 80, 80);
		    bitmapsArray[(Integer)aa.get(6)] = Bitmap.createBitmap(bMapScaled, 0, 160, 80, 80);
		    bitmapsArray[(Integer)aa.get(7)] = Bitmap.createBitmap(bMapScaled, 80, 160, 80, 80);
	        bitmapsArray[(Integer)aa.get(8)] = Bitmap.createBitmap(bMapScaled, 160, 160, 80, 80);  
	        
	  
	        final ImagesAdapter adapter = new ImagesAdapter(this);
        g.setAdapter(adapter);
        
        	g.setOnItemClickListener(new OnItemClickListener() {

			

				public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
					// TODO Auto-generated method stub
					
					
					if(!a ){
						w=arg2;
						System.out.println("on first click:"+a.toString());
						
						
					}
					if(a){
						j=arg2;
						System.out.println("on second click:"+a.toString());
						
						Bitmap temp = bitmapsArray[j];
						bitmapsArray[j] = bitmapsArray[w];
						bitmapsArray[w] = temp;
						adapter.notifyDataSetChanged();
						
						 
					}
					
					a = !a;
				}
			});
		
	}
	class ImagesAdapter extends BaseAdapter{
private Context mc;
		public ImagesAdapter(Context c){
			mc=c;
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return bitmapsArray.length;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			
			return 0;
		}

		public View getView( int position, View convertView, ViewGroup parent) {
         

			im=new ImageView(mc);
			

             im.setImageBitmap(bitmapsArray[position]);
             im.setLayoutParams(new GridView.LayoutParams(100, 100));
          
//             if(bitmapsArray[position].equals(aa1)){
//	        	   Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
//	           }
			
			return im;
			
			
		}
	
		
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	}