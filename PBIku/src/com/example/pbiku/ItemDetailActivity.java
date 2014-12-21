package com.example.pbiku;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailActivity extends Activity {
	// imgid disini list yg akan di tampilkan di activity
	private Integer[] imgid = { R.drawable.nad, R.drawable.sumut,
			R.drawable.sumbar, R.drawable.riau,R.drawable.jambi,R.drawable.sumsel,
			R.drawable.bengkulu,R.drawable.lampung,R.drawable.babel,
			R.drawable.kepulauan_riau,R.drawable.dki_jakarta,R.drawable.jabar,R.drawable.jateng,R.drawable.di_yogyakarta
			,R.drawable.jatim,R.drawable.banten,R.drawable.bali,R.drawable.ntb,R.drawable.ntt
			,R.drawable.kalbar,R.drawable.kalteng,R.drawable.kalsel,R.drawable.kaltim,R.drawable.sulut,
			R.drawable.sulteng,R.drawable.sulsel,R.drawable.sultra,R.drawable.gorontalo,R.drawable.sulbar,
			R.drawable.maluku,R.drawable.malukuutara,R.drawable.papua,R.drawable.papuabarat};

	private TextView nama;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_detail);

		// project ini hanya bisa digunakan min di ICS (4.0) ke atas kalau tidak
		// actionbarnya error
		// dua baris ini untuk mengatur agar action bar aktif
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		image = (ImageView) findViewById(R.id.image_item_detail);

		Bundle b = getIntent().getExtras();
		int intImage = b.getInt("id_gmbr");

		image.setImageResource(imgid[intImage - 1]);

	}

	// ini untuk mengatur aksi action bar ketika d click R.id.home maka akan
	// melakukan finish
	// destroy activity
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
