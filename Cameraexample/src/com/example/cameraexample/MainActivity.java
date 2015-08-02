package com.example.cameraexample;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity
implements View.OnClickListener
{

	Button wall,take;
	ImageView pic;
	Intent i;
	int cameraData = 0;
	Bitmap bmp;

	protected void onCreate(Bundle b)
	{
		super.onCreate(b);
		setContentView(R.layout.activity_main);

		//   http://androidituts.com/android-camera-app-tutorial/
		
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
		wall = (Button) findViewById(R.id.set);
		take = (Button) findViewById(R.id.tak);
		pic = (ImageView) findViewById(R.id.image);

		wall.setOnClickListener(this);
		take.setOnClickListener(this);

	}

	public void onClick(View v)

	{
		switch(v.getId())

		{
		case R.id.set:
			try
			{
				getApplicationContext().setWallpaper(bmp);
				Toast.makeText(getApplicationContext(), "WallpaperSet", Toast.LENGTH_LONG).show();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			break;
		case R.id.tak:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameraData);
			break;

		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK)
		{
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			pic.setImageBitmap(bmp);

		}

	}
}
