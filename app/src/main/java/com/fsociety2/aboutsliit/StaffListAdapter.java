package com.fsociety2.aboutsliit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Isuru Jayathilaka on 2018-03-30.
 */

public class StaffListAdapter extends ArrayAdapter<AcademicStaffModel> {

    private static final String TAG = "StaffListAdapter";

    private Context mContext;
    int mResource;

    public StaffListAdapter(Context context, int resource, ArrayList<AcademicStaffModel> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String pose = getItem(position).getPosition();

        AcademicStaffModel model = new AcademicStaffModel(name, pose);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        TextView tvName = (TextView)convertView.findViewById(R.id.textViewName);
        TextView tvPosition = (TextView)convertView.findViewById(R.id.textViewPosition);

        tvName.setText(name);
        tvPosition.setText(pose);

        return convertView;
    }

}
