package com.example.pbiku;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListMenuActivity extends Activity {
	private SQLiteDatabase newDB;
	private Adapter mDbAdapter;
	private ListView list;
	private String tableName = Helper.DB_TABLE;
	private ArrayList<ItemDetailsModel> results = new ArrayList<ItemDetailsModel>();

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		// ini untuk set view xml activity
		setContentView(R.layout.menu_prov);

		// ini untuk seting list yang ada di list menu
		list = (ListView) findViewById(R.id.list);

		// project ini hanya bisa digunakan min di ICS (4.0) ke atas kalau tidak
		// actionbarnya error
		// dua baris ini untuk mengatur agar action bar aktif
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// ini untuk membuka database
		mDbAdapter = new Adapter(ListMenuActivity.this);
		mDbAdapter.createDatabase();
		mDbAdapter.open();

		// ini untuk menerima data yang di kirim dari activity main
		Bundle b = getIntent().getExtras();
		int value = b.getInt("id_pulau");

		// ini untuk mengambil data dari database sesuai id kategori yg dipilih
		// d activity main
		openAndQueryDatabase(value);

		// nah list yg di dapat d database ditampilkan ke layar
		list.setAdapter(new ItemListBaseAdapter(this, results));
		// ini untuk aksi listnya
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// menuju activity detail
				Intent newIntent = new Intent(ListMenuActivity.this,
						ItemDetailActivity.class);
				// data yang dipilih
				ItemDetailsModel item = results.get(position);
				// mengirim data terpilih
				Bundle b = new Bundle();
				b.putInt("id_prov", item.getIdProv());
				b.putString("nama", item.getNama());
				b.putInt("id_gmbr", item.getImageNumber());
				newIntent.putExtras(b); // Put your id to your next Intent

				// memulai activity detail
				startActivityForResult(newIntent, 0);
				Toast.makeText(getApplicationContext(), item.getNama(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void openAndQueryDatabase(int idPulau) {
		try {
			Helper dbHelper = new Helper(this.getApplicationContext());
			newDB = dbHelper.getWritableDatabase();
			Cursor c = newDB.rawQuery(
					"SELECT id_prov, nama, id_gmbr FROM "
							+ tableName + " WHERE id_pulau ='" + idPulau
							+ "'", null);

			if (c != null) {
				if (c.moveToFirst()) {
					do {

						String Nama = c.getString(c.getColumnIndex("nama"));
						int imageNumber = c.getInt(c
								.getColumnIndex("id_gmbr"));
						int idProv = c.getInt(c
								.getColumnIndex("id_prov"));
						ItemDetailsModel item = new ItemDetailsModel(
								idProv, Nama, imageNumber);
						results.add(item);
					} while (c.moveToNext());
				}
			}
		} catch (SQLiteException se) {
			Log.e(getClass().getSimpleName(),
					"tidak bisa membuat atau membuka database");
		}
	}
}
