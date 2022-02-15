package com.example.td2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Activity_reussi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_reussi);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);
        TextView message =(TextView) findViewById(R.id.message);
        String msg = "Félicitation vous avez réeussi avec une moyene de " + String.valueOf(result);
        message.setText(msg);
        Button home = findViewById(R.id.home);
        Button sms = findViewById(R.id.smsbutton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.putExtra("msg", msg);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });


        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentResult = new Intent();
                intentResult.setAction(Intent.ACTION_SENDTO);
                intentResult.setData(Uri.parse("sms:54230376"));
                intentResult.putExtra("sms_body", msg);
                startActivity(intentResult);
            }
        });


    }
}