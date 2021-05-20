package com.example.csefamily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class view extends AppCompatActivity {
    String s,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

    ImageView back=(ImageView) findViewById(R.id.back);
        TextView tv=(TextView)findViewById(R.id.tv);
        ImageView imageView=(ImageView)findViewById(R.id.img);
        tv.setText(getIntent().getStringExtra("TXT"));

        if(getIntent().getStringExtra("IMG").equals("syllabus"))
        {
            imageView.setImageResource(R.drawable.syllabus);
        }
        else if(getIntent().getStringExtra("IMG").equals("student"))
        {
            imageView.setImageResource(R.drawable.student);
        }




        s = getIntent().getStringExtra("PDF");


        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
             public void onClick(View v) {
                onBackPressed();
        }
        });


        PDFView pdfView=(PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset(s)
        .pages(0, 1, 2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22) // all pages are displayed by default
        .enableSwipe(true) // allows to block changing pages using swipe
        .swipeHorizontal(false)
        .enableDoubletap(true)
        .defaultPage(0)
        .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
        .password(null)
        .scrollHandle(null)
        .enableAntialiasing(true) // improve rendering a little bit on low-res screens
        // spacing between pages in dp. To define spacing color, set view background
        .spacing(0)
        .pageFitPolicy(FitPolicy.WIDTH)
        .load();





        }



@Override
public void onBackPressed() {
        super.onBackPressed();
        }
        }
