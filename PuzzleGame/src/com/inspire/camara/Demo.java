package com.inspire.camara;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class Demo extends Activity{
		

	//public static final Matrix matrix =null;
	
	public ImageView iv;public ImageView iv1;public ImageView iv2;public ImageView iv3;public ImageView iv4;
	public ImageView iv5;public ImageView iv6;public ImageView iv7;
	byte[] bb;
	
	
	public static Bitmap bb1;
	
	
	
	public static Bitmap getBb1() {
		return bb1;
	}



	public static void setBb1(Bitmap bb1) {
		Demo.bb1 = bb1;
	}



	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		
		setContentView(R.layout.demo1);
		
		CameraDemo d=new CameraDemo();
		
		bb=d.getBitMap();
		bb1 = BitmapFactory.decodeByteArray(bb, 0, bb.length);
		Runnable r=new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(200);
					Intent i=new Intent(getApplicationContext(),Demo1.class);
					startActivity(i);
					finish();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(r).start();
//		 ColorMatrix bwMatrix =new ColorMatrix();
//	     	bwMatrix.setSaturation(0);
//	     	final ColorMatrixColorFilter colorFilter= new ColorMatrixColorFilter(bwMatrix);
//	     	
//	     	Paint paint=new Paint();
//	     	paint.setColorFilter(colorFilter);
//	     	Canvas c = new Canvas(bb1);
//	    	c.drawBitmap(bb1, 0, 0, paint);
		/*		bb1.eraseColor(RESULT_OK);*/
		ImageView  iv=(ImageView)findViewById(R.id.img);
//       
////		d.ConvertToBlackAndWhite(bb1);
	 	iv.setImageBitmap(bb1);
	 	 
		
		
		//dv.requestFocus();
	    
}
	public Bitmap greyScaler(Bitmap b) {    
//	     Bitmap grayscaleBitmap = Bitmap.createBitmap(b.getWidth(),
//	            b.getHeight(), Bitmap.Config.RGB_565);
		
	Bitmap	b1=BitmapFactory.decodeByteArray(bb, 0, bb.length);
	
	/*b1=this.getBb1();*/
	    
	     Paint p = new Paint();
	     ColorMatrix cm = new ColorMatrix();
	     cm.setSaturation(0);
	     ColorMatrixColorFilter filter = new ColorMatrixColorFilter(cm);
	     p.setColorFilter(filter);
	     Canvas c = new Canvas(b1);
	     c.drawBitmap(b1, 0, 0, p);
	     return b1;
	}
	/*public Bitmap ConvertToBlackAndWhite(Bitmap bb1){
     	ColorMatrix bwMatrix =new ColorMatrix();
     	bwMatrix.setSaturation(0);
     	final ColorMatrixColorFilter colorFilter= new ColorMatrixColorFilter(bwMatrix);
     	Bitmap b1 = BitmapFactory.decodeByteArray(bb, 0, bb.length);
     	b1=Demo.bb1;
     	Paint paint=new Paint();
     	paint.setColorFilter(colorFilter);
     	Canvas myCanvas =new Canvas(b1);
     	myCanvas.drawBitmap(b1, 0, 0, paint);
     	return b1;
     	}*/
	}

