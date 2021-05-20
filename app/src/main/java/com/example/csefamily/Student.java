package com.example.csefamily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Student extends AppCompatActivity {
    String pdf;
    String txt;
    String img="student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ImageView back=(ImageView) findViewById(R.id.back);
        Button b1=(Button)findViewById(R.id.b1);
        Button b2=(Button)findViewById(R.id.b2);
        Button b3=(Button)findViewById(R.id.b3);
        Button b4=(Button)findViewById(R.id.b4);
        Button b5=(Button)findViewById(R.id.b5);
        Button b6=(Button)findViewById(R.id.b6);
        Button b7=(Button)findViewById(R.id.b7);
        Button b8=(Button)findViewById(R.id.b8);
        Button b9=(Button)findViewById(R.id.b9);
        Button b10=(Button)findViewById(R.id.b10);
        Button b11=(Button)findViewById(R.id.b11);
        Button b12=(Button)findViewById(R.id.b12);
        Button b13=(Button)findViewById(R.id.b13);
        Button b14=(Button)findViewById(R.id.b14);
        Button b15=(Button)findViewById(R.id.b15);
        Button b16=(Button)findViewById(R.id.b16);
        Button b17=(Button)findViewById(R.id.b17);
        Button b18=(Button)findViewById(R.id.b18);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b1.pdf";
                txt="1st Batch";
                openView();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b2.pdf";
                txt="2nd Batch";
                openView();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b3.pdf";
                txt="3rd Batch";
                openView();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b4.pdf";
                txt="4th Batch";
                openView();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b5.pdf";
                txt="5th Batch";
                openView();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b6.pdf";
                txt="6th Batch";
                openView();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b7.pdf";
                txt="7th Batch";
                openView();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b8.pdf";
                txt="8th Batch";
                openView();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b9.pdf";
                txt="9th Batch";
                openView();
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b10.pdf";
                txt="10th Batch";
                openView();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b11.pdf";
                txt="11th Batch";
                openView();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b13.pdf";
                txt="13th Batch";
                openView();
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b14.pdf";
                txt="14th Batch";
                openView();
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b15.pdf";
                txt="15th Batch";
                openView();
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b16.pdf";
                txt="16th Batch";
                openView();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b12.pdf";
                txt="12th Batch";
                openView();
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b17.pdf";
                txt="17th Batch";
                openView();
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdf="b18.pdf";
                txt="18th Batch";
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
