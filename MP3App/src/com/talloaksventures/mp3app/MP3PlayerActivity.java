package com.talloaksventures.mp3app;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import com.example.streamingmp3app.R;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MP3PlayerActivity extends Activity {
	
	private MediaPlayer _mp3Player;
	
	private Button _btnPlayMp3;
	private Button _btnStopMp3;
	
	private TextView _statusLabel;
	
	private ProgressBar _mediaProgress;
	
	private TimerTask _progressTask;
	private Handler _progressHandler;
	private Timer _progressTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_player);
        
        _mp3Player = new MediaPlayer();
        
        _btnPlayMp3 = (Button)findViewById(R.id.button1);
        _btnPlayMp3.setEnabled(true);
        _btnStopMp3 = (Button)findViewById(R.id.button2);
        _btnStopMp3.setEnabled(false);
        
        _mediaProgress = (ProgressBar)findViewById(R.id.progressBar1);
        
        _statusLabel = (TextView)findViewById(R.id.textView1);
        _statusLabel.setText("Stopped");
        
        _btnPlayMp3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				play();
				_btnPlayMp3.setEnabled(false);
			}
		});
        
        _btnStopMp3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stop();
				
			}
		});
        
        _mp3Player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				_mediaProgress.setMax(_mp3Player.getDuration());
				_mp3Player.start();
				_btnStopMp3.setEnabled(true);
				 _statusLabel.setText("Playing");
				 
				 _progressHandler = new Handler();
			     _progressTask = new TimerTask(){

						@Override
						public void run() {
							_progressHandler.post(new Runnable(){
								@Override
								public void run() {
									_mediaProgress.setProgress(_mp3Player.getCurrentPosition());
								}
							});
						}
			        	
			        };
				 
				 _progressTimer = new Timer();
				 _progressTimer.schedule(_progressTask, 1000, 1000);
			}
		});
        
        _mp3Player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
			
			@Override
			public void onBufferingUpdate(MediaPlayer mp, int percent) {
				_statusLabel.setText("Buffering " + percent + " %");
				
			}
		});
        
        _mp3Player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
        
        _mp3Player.setOnInfoListener(new MediaPlayer.OnInfoListener() {
			
			@Override
			public boolean onInfo(MediaPlayer mp, int what, int extra) {
				
				if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START)
				{
					_statusLabel.setText("Buffering Started ");
				}
				else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END)
				{
					_statusLabel.setText("Buffering Stopped ");
				}
				
				return false;
			}
		});   
    }
    
    @Override
	protected void onDestroy() {
    	
    	stop();
		
		super.onDestroy();
	}
    
    private void play()
    {
    	try {
			
    		_mp3Player.setDataSource(this.getApplicationContext(), Uri.parse("android.resource://com.example.streamingmp3app/raw/test"));
			_mp3Player.prepareAsync();
			
			_statusLabel.setText("Preparing Player");
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    private void stop()
    {
    	// Make sure this is null before canceling
    	if (_progressTimer != null)
    	{
    		_progressTimer.cancel();
    	}
    	
    	_progressHandler = null;
	    _progressTask = null;
    	
    	_mp3Player.stop();
    	_mp3Player.reset();
    	
    	_statusLabel.setText("Stopped");
		_btnPlayMp3.setEnabled(true);
		_btnStopMp3.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mp3_stream, menu);
        return true;
    }
    
}
