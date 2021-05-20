package com.example.csefamily;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String pdf="",txt="";
    private DrawerLayout dl;
    ActionBarDrawerToggle toggle;
    WebView webView;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.hi:
                Intent intent=new Intent(this,aboutCSE.class);
                startActivity(intent);
                finish();
                break;
        }
        dl.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button history = findViewById(R.id.bh);
        Button student = findViewById(R.id.bs);
        Button syllabus = findViewById(R.id.bsy);
        Button routine = findViewById(R.id.br);
        Button book = findViewById(R.id.bb);
        Button worker = findViewById(R.id.bw);
        Button btnLogin = findViewById(R.id.btnlogin);
        Button btnAbout = findViewById(R.id.btnAbout);
        Button faculty=(Button) findViewById(R.id.bt);
        Button officer=(Button) findViewById(R.id.bo);
        webView=(WebView) findViewById(R.id.webid);

        //Navigation bar codes start


        dl = findViewById(R.id.dl);
        toggle = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        toggle.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(toggle);
        toggle.syncState();

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navView = findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);



        //Navigation bar coedes end





        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaculty();
            }
        });

        officer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOfficer();
            }
        });

        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorker();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // pdf="aboutus.pdf";
               // txt="About Us";
               // openView();
                openAbout();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudent();
            }
        });
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSyllabus();
            }
        });

       // book.setMovementMethod(LinkMovementMethod.getInstance());
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                WebSettings webSettings=webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                //webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://drive.google.com/open?id=1rRpTYS4jt7z4sHB-EWEC2EGnJxSol1KJ");
            }
        });

        routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoutine();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbtnLogin();
            }
        });




    }

    public void openView()
    {

        Intent intent=new Intent(this,view.class);
        intent.putExtra("PDF",pdf);
        intent.putExtra("TXT",txt);
        startActivity(intent);
    }

    public void openStudent()
    {
        Intent intent=new Intent(this,Student.class);
        startActivity(intent);
        finish();
    }

    public void openFaculty()
    {
        Intent intent=new Intent(this,Faculty.class);
        startActivity(intent);
        finish();
    }

    public void openOfficer(){
        Intent intent=new Intent(this,Officer.class);
        startActivity(intent);
        finish();
    }

    public void openWorker()
    {
        Intent intent=new Intent(this,worker.class);
        startActivity(intent);
        finish();
    }

    public void openInfo()
    {
        Intent intent=new Intent(this,aboutCSE.class);
        startActivity(intent);
        finish();
    }

    public void openSyllabus()
    {
        Intent intent=new Intent(this,Syllabus.class);
        startActivity(intent);
        finish();
    }
    /*
    public void openBook()
    {
        Intent intent=new Intent(this,Syllabus.class);
        startActivity(intent);
        finish();
    }
    */

    public void openRoutine()
    {
        Intent intent= new Intent(this,Routine.class);
        startActivity(intent);
        finish();
    }

    public void openbtnLogin()
    {
        Intent intent= new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    public void operbtnSignUp()
    {
        Intent intent= new Intent(this,SignUp.class);
        startActivity(intent);
        finish();
    }
    public void openAbout()
    {
        Intent intent= new Intent(this,aboutUs.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        else {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Closing Activity")
                    .setMessage("Are you sure you want to close this activity?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

}
