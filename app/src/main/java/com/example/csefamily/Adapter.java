package com.example.csefamily;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<insertData> {

    Activity context;
    List<insertData> dataList;


    public Adapter(Activity context, List<insertData> dataList) {
        super(context, R.layout.activity_layout, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    public void setDataList(List<insertData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_layout, null, true);

        insertData data = dataList.get(position);

        TextView txtName = view.findViewById(R.id.txtNameView);
        TextView txtDesignation = view.findViewById(R.id.txtDesignationView);
        TextView txtDegree = view.findViewById(R.id.txtDegreeView);
        TextView txtPhone = view.findViewById(R.id.txtPhoneView);
        TextView txtEmail = view.findViewById(R.id.txtEmailView);

        txtName.setText("Name : " + data.getName());
        txtDesignation.setText("Designation : " + data.getDesignation());
        txtDegree.setText("Degree : " + data.getDegree());
        txtPhone.setText("Phone : " + data.getPhone());
        txtEmail.setText("Email : " + data.getEmail());


        return view;
    }
}
