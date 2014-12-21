package com.example.pbiku;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Helper extends SQLiteOpenHelper {
	private static String TAG = Helper.class.getName();
	private static String DB_PATH = "/data/data/com.example.pbi/databases/";
	private static String DB_NAME = "pbi.sqlite";
	static String DB_TABLE = "tb_provinsi";
	private SQLiteDatabase myDataBase = null;
	private final Context myContext;

	public Helper(Context context) {
		super(context, DB_NAME, null, 1);
		DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		this.myContext = context;
		Log.v("log_tag", "DBPath: " + DB_PATH);
	}

	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();
		if (dbExist) {
			Log.v("log_tag", "database does exist");
		} else {
			Log.v("log_tag", "database does not exist");
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}
	}

	private void copyDataBase() throws IOException {
		InputStream myInput = myContext.getAssets().open(DB_NAME);
		String outFileName = DB_PATH + DB_NAME;
		OutputStream myOutput = new FileOutputStream(outFileName);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		} catch (SQLiteException e) {
			Log.v(TAG, e.toString() + "   database doesn't exists yet..");
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null;
	}

	public boolean openDataBase() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		return myDataBase != null;
	}

	// / metode bawaan
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.v(TAG, "Upgrading database, this will drop database and recreate.");
	}

}
