package com.clicks.yogi.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialog;
    Button MyButtonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyButtonID = findViewById(R.id.MyButtonID);

        // Alert DialogBox code...
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Are you sure");
        // follow Step number 3...
//        alertDialog.setIcon(R.drawable.icons);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Next Activity",
                        Toast.LENGTH_SHORT).show();
                // Follow Step No. 4...
                Intent i = new Intent(MainActivity.this,NextActivity.class);
                startActivity(i);
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Exit application",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel the DialogBox",
                        Toast.LENGTH_SHORT).show();
            }
        });

        MyButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });

    }
}
