package com.shubham.mynewapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneCall extends AppCompatActivity {

    EditText et1;
    Button btncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        et1 = (EditText) findViewById(R.id.editText9);
        btncall = (Button) findViewById(R.id.button4);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(Intent.ACTION_CALL);

                String mob = et1.getText().toString();
                ob.setData(Uri.parse("tel:"+mob));
                startActivity(ob);
            }
        });
    }
}
