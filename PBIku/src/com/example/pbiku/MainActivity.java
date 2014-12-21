package com.example.pbiku;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_peta);
		
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

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
	
	public void sumatra(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 1);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void jawa(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 2);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void kalimantan(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 3);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void sulawesi(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 4);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void maluku(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 5);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void balint(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 6);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
	public void papua(View v) {

		Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
		Bundle b = new Bundle();
		b.putInt("id_pulau", 7);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
	}
	
}
