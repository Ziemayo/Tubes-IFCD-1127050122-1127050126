package com.example.pbiku;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		//project ini hanya bisa digunakan min di ICS (4.0) ke atas kalau tidak 
		//actionbarnya error
		//dua baris ini untuk mengatur agar action bar aktif
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Tentang");
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	//ini untuk mengatur aksi action bar ketika d click R.id.home maka akan melakukan finish
	//destroy activity
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
