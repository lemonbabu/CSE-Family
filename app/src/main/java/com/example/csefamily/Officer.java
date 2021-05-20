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

public class Officer extends AppCompatActivity {

    DatabaseReference dbReference;
    ListView lstViewData;
    List<insertData> dataList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer);
        dbReference = FirebaseDatabase.getInstance().getReference("Officer");
        lstViewData = findViewById(R.id.lstViewData);
        ImageView back=(ImageView) findViewById(R.id.back);
        dataList = new ArrayList<>();
        adapter = new Adapter(Officer.this, dataList);

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
