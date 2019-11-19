package com.example.thirdeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bcall, bmsg, bwalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bcall= findViewById(R.id.call);
        bmsg = findViewById(R.id.msg);
        bwalk = findViewById(R.id.walk);

        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, call.class);
                startActivity(intent);
            }
        });
        bmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, walk.class);
                startActivity(intent);
            }
        });
        bwalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, walk.class);
                startActivity(intent);
            }
        });


    }//onCreate


}//Class
