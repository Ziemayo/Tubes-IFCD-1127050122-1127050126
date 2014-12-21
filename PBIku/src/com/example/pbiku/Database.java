package com.example.pbiku;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class Database extends SQLiteOpenHelper {
    final static String DB_NAME = "db_kuis";
 
    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER, img BLOB)";
        db.execSQL(sql);
 
        ContentValues values = new ContentValues();
        values.put("soal", "Rumah adat jawa barat adalah?");
        values.put("pil_a", "Rumah Musalaki");
        values.put("pil_b","Rumah Kebaya");
        values.put("pil_c", "Keraton Kasepuhan Cirebon");
        values.put("jwban","2");
        values.put("img", R.drawable.rumahjabar);
        db.insert("tbl_soal", "soal", values);
 
        values.put("soal", "Tarian khas bali adalah ?");
        values.put("pil_a", "Tari Tandak");
        values.put("pil_b","Tari Pendet");
        values.put("pil_c", "Tari Piring");
        values.put("jwban","1");
        values.put("img", R.drawable.taribali);
        db.insert("tbl_soal", "soal", values);
         
        values.put("soal", "Pakaian adat manakan ini ?");
        values.put("pil_a", "Sumatra Timur");
        values.put("pil_b","Sulawesi Timur");
        values.put("pil_c", "Kalimantan Timur");
        values.put("jwban","2");
        values.put("img", R.drawable.bajuadatkaltim);
        db.insert("tbl_soal", "soal", values);
         
        values.put("soal", "Gambar diatas adalah senjata khas provinsi ?");
        values.put("pil_a", "Nangroe Aceh Darussalam");
        values.put("pil_b","Jawa Barat");
        values.put("pil_c", "Maluku Utara");
        values.put("jwban","0");
        values.put("img", R.drawable.senjatanad);
        db.insert("tbl_soal", "soal", values);
 
        values.put("soal", "Rumah diatas merupakan rumah adat Gorontalo yang bernama?");
        values.put("pil_a", "Rumah Tongkonan");
        values.put("pil_b","Rumah Dulohupa");
        values.put("pil_c", "Rumah Istana Buton");
        values.put("jwban","1");
        values.put("img", R.drawable.ic_launcher);
        db.insert("tbl_soal", "soal", values);
        
        String sql2 = "CREATE TABLE IF NOT EXISTS tbl_gambar(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, img BLOB)";
        db.execSQL(sql2);
       
        ContentValues v = new ContentValues();
        v.put("nama", "Rumahjabar");
        v.put("img", R.drawable.rumahjabar);
        db.insert("tbl_gambar", "nama", v);
 
        v.put("nama", "TariBali");
        v.put("img", R.drawable.taribali);
        db.insert("tbl_gambar", "nama", v);
 
    }
     
    public List<Soal> getSoal(){
        List<Soal> listSoal = new ArrayList<Soal>();
        String query = "select * from tbl_soal";
         
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
         
        if(cursor.moveToFirst()){
            do{
                Soal s = new Soal();
                s.setSoal(cursor.getString(1));
                s.setPil_a(cursor.getString(2));
                s.setPil_b(cursor.getString(3));
                s.setPil_c(cursor.getString(4));
                s.setJwban(cursor.getInt(5));
                s.setGambar(cursor.getInt(6));
                listSoal.add(s);
            }while(cursor.moveToNext());
        }
         
        return listSoal;
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_soal");
        db.execSQL("DROP TABLE IF EXISTS tbl_gambar");
        onCreate(db); 
    }
 
}