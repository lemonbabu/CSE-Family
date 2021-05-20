package com.example.csefamily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    private ProgressBar pb;
    private int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pb=(ProgressBar) findViewById(R.id.pbar);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startMain();
            }
        });
        thread.start();


    }

    public void doWork()
    {
        for(prog=1;prog<=100;prog+=1)
        {
            try {
                Thread.sleep(30);
                pb.setProgress(prog);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void startMain()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
