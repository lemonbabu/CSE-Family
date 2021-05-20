package com.example.csefamily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Syllabus extends AppCompatActivity {
    String pdf="",txt="",img="syllabus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        ImageView back=(ImageView) findViewById(R.id.back);
        Button b12=(Button) findViewById(R.id.b12);
        Button b21=(Button) findViewById(R.id.b21);
        Button b22=(Button) findViewById(R.id.b22);
        Button b31=(Button) findViewById(R.id.b31);
        Button b32=(Button) findViewById(R.id.b32);
        Button b41=(Button) findViewById(R.id.b41);
        Button b42=(Button) findViewById(R.id.b42);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s12.pdf";
                txt="Syllabus of 1/2";
                openView();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s21.pdf";
                txt="Syllabus of 2/1";
                openView();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s22.pdf";
                txt="Syllabus of 2/2";
                openView();
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s31.pdf";
                txt="Syllabus of 3/1";
                openView();
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s32.pdf";
                txt="Syllabus of 3/2";
                openView();
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s41.pdf";
                txt="Syllabus of 4/1";
                openView();
            }
        });
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="s42.pdf";
                txt="Syllabus of 4/2";
                openView();
            }
        });
    }

    public void openView()
    {

        Intent intent=new Intent(this,view.class);
        intent.putExtra("PDF",pdf);
        intent.putExtra("TXT",txt);
        intent.putExtra("IMG",img);
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
