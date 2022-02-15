package com.example.td2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_echec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_echec);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);
        TextView message =(TextView) findViewById(R.id.message);
        String msg = "Désolé vous avez obtenue une moyenne de " + String.valueOf(result);
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