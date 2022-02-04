package com.example.varosok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME="varosok.db";
    public static final int DB_VERSION=1;
    public final String Varos_table="Varos";
    public final String COL_ID="id";
    public final String COL_nev="nev";
    public final String COL_orszag="orszag";
    public final String COL_lakossag="lakossag";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+ Varos_table+"("
                +COL_ID +"INTEGER Primary Key AUTOINCREMENT,"
                +COL_nev +" VARCHAR(255) NOT NULL UNIQUE,"
                +COL_orszag+" VARCHAR(255) not null,"
                +COL_lakossag+" INTEGER(255) not null"
                +")";

                sqLiteDatabase.execSQL(sql); //adatbázis létrehozás
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql="DROP Table IF EXISTS "+Varos_table;
        sqLiteDatabase.execSQL(sql);
        onCreate (sqLiteDatabase);


    }
    public boolean Adatrogzites(String nev,String orszag,String lakossag){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_nev,nev);
        values.put(COL_orszag,orszag);
        values.put(COL_lakossag,lakossag);
        return db.insert(Varos_table,null,values)!=-1;
    }
    public Cursor adatLekerdezes(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db.query(Varos_table,new String[]{COL_ID,COL_nev,COL_orszag,COL_lakossag},
                null,null,null,null,null);

    }
}
