package com.shubham.mynewapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnsave;
    EditText txtrno, txtname,txtmob;

    myhelper ob;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = (Button)findViewById(R.id.button);
        txtrno = (EditText)findViewById(R.id.editText);
        txtname = (EditText)findViewById(R.id.editText2);
        txtmob = (EditText)findViewById(R.id.editText3);
        ob=new myhelper(this);

        btnsave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db=ob.getWritableDatabase();
                String rno=txtrno.getText().toString();
                String name=txtname.getText().toString();
                String mob=txtmob.getText().toString();

                db.execSQL("insert into student(RollNo,Name,Mobile)values("+rno+",'"+name+"','"+mob+"')");
                Toast.makeText(getApplicationContext(),"Record Saved",Toast.LENGTH_LONG).show();
            }
        });

    }
}
