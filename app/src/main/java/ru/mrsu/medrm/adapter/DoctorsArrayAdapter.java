package ru.mrsu.medrm.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.model.Doctor;
import ru.mrsu.medrm.model.Service;

public class DoctorsArrayAdapter extends ArrayAdapter<Doctor> {

    public DoctorsArrayAdapter(Context context, ArrayList<Doctor> doctor) {
        super(context, 0, doctor);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Doctor doctor = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.doctor_list_item, parent, false);
        }
        TextView nameTextView = (TextView) convertView.findViewById(R.id.doctor_name);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.doctor_work_time);
        nameTextView.setText(doctor.getName());
        timeTextView.setText(doctor.getStartTime() + " -- " + doctor.getEndTime());
        return convertView;
    }


}
