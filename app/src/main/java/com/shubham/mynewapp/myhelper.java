package com.shubham.mynewapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myhelper extends SQLiteOpenHelper
{
    static final String dbname="mydb.db";
    static final int ver=1;
    public myhelper(Context c)
    {
        super(c,dbname,null,ver);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table student(RollNo integer primary key,Name text,Mobile text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
