package com.example.pbiapp;

import org.w3c.dom.Text;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ActionBar;
import android.app.Activity;


public class MenuProv extends Activity {

	static final String[] MENU = new String[] { 
		"Nanggroe Aceh Darussalam", "Sumatra Utara", "Sumatra Barat", 
		"Riau", "Jambi", "Sumatra Selatan",
		"Bengkulu", "Lampung", "Kepulauan Bangka Belitung",
		"Kepulauan Riau", "DKI Jakarta", "Jawa Barat ",
		"Jawa Tengah", " DI Yogyakarta", "Jawa Timur",
		"Banten", "Bali", "Nusa Tenggara Barat ",
		"Nusa Tenggara Timur ", "Kalimantan Barat", "Kalimantan Tengah",
		"Kalimantan Selatan", "Kalimantan Timur", "Sulawesi Utara",
		"Sulawesi Tengah", "Sulawesi Selatan ", "Sulawesi Tenggara",
		"Gorontalo", "Sulawesi Barat  ", "Maluku",
		"Maluku Utara", "Papua", "Papua Barat" };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_prov);
		
        TextView dftr = (TextView) findViewById(R.id.dftrprov);
        dftr.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        
        
        ListView listView = (ListView) findViewById(R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, android.R.id.text1, MENU);
		listView.setAdapter(adapter);
		
		
		// ListView Item Click Listener
				/*listView.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						if (position == 4) {
							Intent newIntent = new Intent(MenuProv.this,
									detail_prov.class);

							startActivityForResult(newIntent, 0);

						} else {
							Intent newIntent = new Intent(MenuProv.this,
									MainActivity.class);
							Bundle b = new Bundle();
							b.putInt("id_prov", position+1); //Your id
							newIntent.putExtras(b); //Put your id to your next Intent
							startActivityForResult(newIntent, 0);

						}
					}
				});
}*/
}
}
