package com.example.csefamily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Routine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        ImageView back=(ImageView) findViewById(R.id.back);
        Button b12=(Button)findViewById(R.id.b12);
        Button b21=(Button)findViewById(R.id.b21);
        Button b22=(Button)findViewById(R.id.b22);
        Button b31=(Button)findViewById(R.id.b31);
        Button b32=(Button)findViewById(R.id.b32);
        Button b41=(Button)findViewById(R.id.b41);
        Button b42=(Button)findViewById(R.id.b42);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutin();
            }
        });
    }




    public void openRoutin()
    {
        Intent intent=new Intent(this,Routin.class);
        startActivity(intent);
    }
    public void openMain()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        openMain();
        super.onBackPressed();
    }
}
