package com.fsociety2.aboutsliit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private int mResource;
    private int lastPosition = -1;

    /**
     * holds variables in a view
     */
    static class ViewHolder {
        TextView name;
        TextView position;
    }

    /**
     * default constructor for the StaffListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public StaffListAdapter(Context context, int resource, ArrayList<AcademicStaffModel> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get staff information
        String name = getItem(position).getName();
        String pose = getItem(position).getPosition();

        //create the staff object with the information
        AcademicStaffModel model = new AcademicStaffModel(name, pose);

        //create the view result for showing the animation
        final View result;
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.position = (TextView) convertView.findViewById(R.id.textViewPosition);

            result = convertView;
            convertView.setTag(holder);
        }else {
            //tag store view in memory
            holder = (ViewHolder)convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition)? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(model.getName());
        holder.position.setText(model.getPosition());

        return convertView;
    }

}
