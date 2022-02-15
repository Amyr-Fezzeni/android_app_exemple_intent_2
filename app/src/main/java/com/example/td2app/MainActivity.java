package com.example.td2app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText note1 = findViewById(R.id.note1);
        EditText note2 = findViewById(R.id.note2);
        EditText note3 = findViewById(R.id.note3);

        Button calculer = findViewById(R.id.calculer);
        builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//
            }
        });
        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (note1.getText().toString().equals("")
                        || note2.getText().toString().equals("")
                        || note3.getText().toString().equals("")) {

                AlertDialog alert = builder.create();
                alert.show();
                }
                else
                    {
                    double result = (Double.parseDouble(note1.getText().toString()) + Double.parseDouble(note2.getText().toString()) + Double.parseDouble(note3.getText().toString()) ) / 3;
                    if (result > 10) {
                        Intent intent = new Intent(MainActivity.this, Activity_reussi.class);
                        intent.putExtra("result", result);
                        startActivityForResult(intent, 1);

                    }else{
                        Intent intent = new Intent(MainActivity.this, Activity_echec.class);
                        intent.putExtra("result", result);
                        startActivityForResult(intent, 1);
                    }
                    }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
            String msg = data.getStringExtra("msg");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}