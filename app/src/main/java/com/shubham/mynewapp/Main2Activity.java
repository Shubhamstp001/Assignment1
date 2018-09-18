package com.shubham.mynewapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity
{
    ListView lview1;

    myhelper ob;
    SQLiteDatabase db;
    Cursor cr;

    HashMap<String,String> map;

    ArrayList<HashMap<String,String>> alist;

    SimpleAdapter adp;

    void LoadRecord()
    {
        db=ob.getReadableDatabase();
        cr=db.rawQuery("select * from student",null);
        alist=new ArrayList<HashMap<String,String>>();
        while(cr.moveToNext())
        {
            map=new HashMap<String,String>();
            map.put("rno",cr.getInt(0)+"");
            map.put("name",cr.getString(1));
            map.put("mob",cr.getString(2));
            alist.add(map);
        }
        cr.close();
        adp=new SimpleAdapter(this,alist,R.layout.row,new String[]{"rno","name","mob"},new int[]{R.id.textView5,R.id.textView6,R.id.textView4});
        lview1.setAdapter(adp);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lview1=(ListView)findViewById(R.id.lst1);
        ob=new myhelper(this);
        LoadRecord();
    }
}
