package com.shubham.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends AppCompatActivity {

    EditText t1, t2, t3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        t1 = (EditText) findViewById(R.id.editText6);
        t2 = (EditText) findViewById(R.id.editText7);
        t3 = (EditText) findViewById(R.id.editText8);

        btn = (Button) findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = t1.getText().toString();
                String sub = t2.getText().toString();
                String msg = t3.getText().toString();

                Intent ob = new Intent(Intent.ACTION_SEND);
                ob.putExtra(Intent.EXTRA_EMAIL,new String[]{em});
                ob.putExtra(Intent.EXTRA_SUBJECT,sub);
                ob.putExtra(Intent.EXTRA_TEXT,msg);
                ob.setType("message /rfc822");
                startActivity(Intent.createChooser(ob,"choose client"));
            }
        });
    }
}
