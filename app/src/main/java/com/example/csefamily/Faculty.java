package com.example.csefamily;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends AppCompatActivity {

    DatabaseReference dbReference;
    ListView lstViewData;
    List<insertData> dataList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        dbReference = FirebaseDatabase.getInstance().getReference("Faculty");
        lstViewData = findViewById(R.id.lstViewData);
        dataList = new ArrayList<>();
        ImageView back=(ImageView) findViewById(R.id.back);
        adapter = new Adapter(Faculty.this, dataList);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    insertData data = dataSnapshot1.getValue(insertData.class);
                    dataList.add(data);
                }
                lstViewData.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
