package com.fsociety2.aboutsliit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AcademicStaff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_staff);
        ListView listView = (ListView)findViewById(R.id.list_view);
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header_view_layout, listView, false);
        listView.addHeaderView(headerView);

        DBHelper helper = new DBHelper(this);
        AcademicStaffModel sample1 = new AcademicStaffModel(0,"Professor","Lalith Gamage","President");
        AcademicStaffModel sample2 = new AcademicStaffModel(0, "Professor", "Lakshman Rathnayake", "Chairman");
        helper.save(sample1);
        helper.save(sample2);

        List<AcademicStaffModel> list = helper.readAll();

        StaffListAdapter adapter = new StaffListAdapter(this, R.layout.adapter_view_layout, (ArrayList<AcademicStaffModel>) list);
        listView.setAdapter(adapter);

    }
}
