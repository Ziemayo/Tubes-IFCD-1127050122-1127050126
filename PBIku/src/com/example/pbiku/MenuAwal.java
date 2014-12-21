package com.example.pbiku;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MenuAwal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        TextView textView3 = (TextView) findViewById(R.id.textView2);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        Button btn_msk1 = (Button) findViewById(R.id.button1);
        btn_msk1.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        Button btn_msk2 = (Button) findViewById(R.id.button2);
        btn_msk2.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        Button btn_kluar = (Button) findViewById(R.id.button3);
        btn_kluar.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));*/
	}
	
	public void pulau(View v) {
		Intent intent = new Intent(MenuAwal.this, MainActivity.class);
		startActivityForResult(intent, 0);
	}
	
	public void test(View v) {
		Intent intent = new Intent(MenuAwal.this, QuizActivity.class);
		startActivityForResult(intent, 0);
	}
	
	public void about(View v) {
		Intent intent = new Intent(MenuAwal.this, AboutActivity.class);
		startActivityForResult(intent, 0);
	}
	
	}
