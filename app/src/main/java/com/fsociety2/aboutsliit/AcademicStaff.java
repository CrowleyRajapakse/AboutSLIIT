package com.fsociety2.aboutsliit;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class AcademicStaff extends AppCompatActivity {

    private ListView listView;
    private List<AcademicStaffModel> list;
    private StaffListAdapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_staff);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Academic Staff");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        listView = (ListView) findViewById(R.id.list_view);

        DBHelper helper = new DBHelper(this);
        AcademicStaffModel sample1 = new AcademicStaffModel(0, "Professor", "L. Gamage", "President");
        AcademicStaffModel sample2 = new AcademicStaffModel(0, "Professor", "L.L. Ratnayake", "Chairman");
        AcademicStaffModel sample3 = new AcademicStaffModel(0, "Professor", "K.N. Pulasinghe", "Dean - Faculty of Computing");
        AcademicStaffModel sample4 = new AcademicStaffModel(0, "Professor", "H.S. Thilakasiri", "Dean - Faculty of Engineering");
        AcademicStaffModel sample5 = new AcademicStaffModel(0, "Professor", "H.S.C. Perera", "Dean - Faculty of Business");
        AcademicStaffModel sample6 = new AcademicStaffModel(0, "Dr.", "N.N. Wijesundara", "Dean - Education & Student Experience");
        AcademicStaffModel sample7 = new AcademicStaffModel(0, "Professor", "S. Karunaratne", "Academic Adviser");
        AcademicStaffModel sample8 = new AcademicStaffModel(0, "Professor(Mrs)", "G.M.S. Kapurubandara", "Dean - International");
        AcademicStaffModel sample9 = new AcademicStaffModel(0, "Professor", "C. Jayawardene", "Head - Internal Quality Assurance Unit");
        AcademicStaffModel sample10 = new AcademicStaffModel(0, "Professor", "T.A.S.S. Thelijjagoda", "Dean - Faculty of Graduate Studies & Research");
        AcademicStaffModel sample11 = new AcademicStaffModel(0, "Dr.", "P.K.W. Abeygunawardhana", "Head - Department of Information Systems Engineering");
        AcademicStaffModel sample12 = new AcademicStaffModel(0, "Mr.", "Y.W. Mallawarachchi", "Head - Software Engineering Services");
        AcademicStaffModel sample13 = new AcademicStaffModel(0, "Dr(Mrs)", "D.P. Samarasinghe", "Head - Department of Information Technology");
        AcademicStaffModel sample14 = new AcademicStaffModel(0, "Dr.", "A.P.N. Somaratne", "Head - Department of Civil Engineering");
        AcademicStaffModel sample15 = new AcademicStaffModel(0, "Dr.", "G.N. Kodagoda", "Senior Lecturer(Higher Grade)");
        AcademicStaffModel sample16 = new AcademicStaffModel(0, "Dr.", "T. Suraweera", "Senior Lecturer(Higher Grade)");
        AcademicStaffModel sample17 = new AcademicStaffModel(0, "Mr.", "J. Amararachchi", "Senior Lecturer(Higher Grade)");

        helper.delete();
        helper.save(sample1);
        helper.save(sample2);
        helper.save(sample3);
        helper.save(sample4);
        helper.save(sample5);
        helper.save(sample6);
        helper.save(sample7);
        helper.save(sample8);
        helper.save(sample9);
        helper.save(sample10);
        helper.save(sample11);
        helper.save(sample12);
        helper.save(sample13);
        helper.save(sample14);
        helper.save(sample15);
        helper.save(sample16);
        helper.save(sample17);


        list = helper.readAll();

        adapter = new StaffListAdapter(this, R.layout.adapter_view_layout, (ArrayList<AcademicStaffModel>) list);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                newText = newText.toLowerCase();
                if (newText != null && !newText.isEmpty()) {
                    List<AcademicStaffModel> searchList = new ArrayList<AcademicStaffModel>();
                    for (AcademicStaffModel model : list) {
                        if (model.getName().toLowerCase().contains(newText) || model.getPosition().toLowerCase().contains(newText)) {
                            searchList.add(model);
                        }

                    }
                    StaffListAdapter adapter = new StaffListAdapter(AcademicStaff.this, R.layout.adapter_view_layout, (ArrayList<AcademicStaffModel>) searchList);
                    listView.setAdapter(adapter);
                } else {
                    StaffListAdapter adapter = new StaffListAdapter(AcademicStaff.this, R.layout.adapter_view_layout, (ArrayList<AcademicStaffModel>) list);
                    listView.setAdapter(adapter);
                }
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
