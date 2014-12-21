package com.example.pbiku;

import java.io.IOException;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class Adapter {

	private final Context mCtx;
	// private SQLiteDatabase mDb;
	private Helper mDbHelper;

	protected static final String TAG = Adapter.class.getName();

	public Adapter(Context ctx) {
		this.mCtx = ctx;
		mDbHelper = new Helper(mCtx);
	}

	public Adapter createDatabase() throws SQLException {
		try {
			mDbHelper.createDataBase();
			Log.v(TAG, "database created");
		} catch (IOException ioe) {
			Log.v(TAG, ioe.toString() + "  Unable to create database.");
			throw new Error("Unable to create database");
		}
		return this;
	}

	public Adapter open() throws SQLException {
		// Create and open Database
		try {
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDbHelper.getReadableDatabase();
		} catch (SQLException sqle) {
			Log.v(TAG, sqle.toString());
			throw sqle;
		}
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

}
