package com.example.pbiapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
       
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        
        Button btn_msk1 = (Button) findViewById(R.id.button1);
        btn_msk1.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        Button btn_msk2 = (Button) findViewById(R.id.button2);
        btn_msk2.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        Button btn_kluar = (Button) findViewById(R.id.button3);
        btn_kluar.setTypeface(Typeface.createFromAsset(getAssets(), "COMIC.TTF"));
        
        showMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

private void showMenu(){
    Button btnprov = (Button) findViewById(R.id.button1);
    btnprov.setOnClickListener(new View.OnClickListener() {
        public void onClick(View arg0) {
        	Intent nextScreen = new Intent(getApplicationContext(), MenuProv.class); 
            startActivity(nextScreen);
        }
    });
}
}
