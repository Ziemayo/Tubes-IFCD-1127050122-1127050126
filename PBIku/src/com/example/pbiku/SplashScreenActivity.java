package com.example.pbiku;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ProgressBar;

public class SplashScreenActivity extends Activity {
	protected boolean _active = true;
	protected int _splashTime = 3000;
	protected ProgressBar progresBar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.splash);

		final ProgressBar progresBar = (ProgressBar) findViewById(R.id.progressBar1);

		// thread for displaying the SplashScreen
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 100;
							progresBar.setProgress(waited);
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					finish();
					Intent newIntent = new Intent(SplashScreenActivity.this,
							MenuAwal.class);
					startActivityForResult(newIntent, 0);
				}
			}
		};
		splashTread.start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			_active = false;
		}
		return true;
	}

}
