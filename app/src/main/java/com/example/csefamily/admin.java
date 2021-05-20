package com.example.csefamily;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin extends AppCompatActivity {
    EditText txtName, txtDesignation, txtDegree, txtPhone, txtEmail, txtCategory;
    Button btnInsert, btnShowFrm, btnShow;
    ListView lstViewData;
    DatabaseReference dbRefWorker, dbRefFaculty, dbRefOfficer, dbRefStudent;

    List<insertData> dataList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ImageView back=(ImageView) findViewById(R.id.back);
        txtName = findViewById(R.id.txtName);
        txtDesignation = findViewById(R.id.txtDesignation);
        txtDegree = findViewById(R.id.txtDegree);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtCategory = findViewById(R.id.txtCategory);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowFrm = findViewById(R.id.btnShowFrm);
        lstViewData = findViewById(R.id.lstViewData);

        dbRefWorker = FirebaseDatabase.getInstance().getReference("Worker");
        dbRefFaculty = FirebaseDatabase.getInstance().getReference("Faculty");
        dbRefOfficer = FirebaseDatabase.getInstance().getReference("Officer");
        dbRefStudent = FirebaseDatabase.getInstance().getReference("Student");


        dataList = new ArrayList<>();
        adapter = new Adapter(admin.this, dataList);


        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        btnShowFrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


    public void insertData(){
        String name = txtName.getText().toString().trim();
        String designation = txtDesignation.getText().toString().trim();
        String degree = txtDegree.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String category = txtCategory.getText().toString().trim();
        String ct[] = {"Worker", "Faculty", "Officer", "Student"};

        if(category.equals(ct[0])) {
            String key = dbRefWorker.push().getKey();
            insertData data = new insertData(name, designation, degree, phone, email);
            assert key != null;
            dbRefWorker.child(key).setValue(data);
            Toast.makeText(getApplicationContext(), "Insert data successfully", Toast.LENGTH_LONG).show();
            clean();
        }
        else if(category.equals(ct[1])){

            String key = dbRefFaculty.push().getKey();
            insertData data = new insertData(name, designation, degree, phone, email);
            assert key != null;
            dbRefFaculty.child(key).setValue(data);
            Toast.makeText(getApplicationContext(), "Insert data successfully", Toast.LENGTH_LONG).show();
            clean();
        }

        else if(category.equals(ct[2])){
            String key = dbRefOfficer.push().getKey();
            insertData data = new insertData(name, designation, degree, phone, email);
            assert key != null;
            dbRefOfficer.child(key).setValue(data);
            Toast.makeText(getApplicationContext(), "Insert data successfully", Toast.LENGTH_LONG).show();
            clean();
        }

        else if(category.equals(ct[3])){
            String key = dbRefStudent.push().getKey();
            insertData data = new insertData(name, designation, degree, phone, email);
            assert key != null;
            dbRefStudent.child(key).setValue(data);
            Toast.makeText(getApplicationContext(), "Insert data successfully", Toast.LENGTH_LONG).show();
            clean();
        }

        else {
            Toast.makeText(getApplicationContext(), category + " Category is incorrect!\n Exm: Worker/Faculty/Officer/Student", Toast.LENGTH_LONG).show();
        }
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

    void clean(){
        txtName.setText("");
        txtDesignation.setText("");
        txtDegree.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtCategory.setText("");
    }

}
