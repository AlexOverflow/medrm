package ru.mrsu.medrm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.model.Hospital;

public class HospitalArrayAdapter extends ArrayAdapter<Hospital> {
    public HospitalArrayAdapter(Context context, ArrayList<Hospital> hospitals) {
        super(context, 0, hospitals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       /* // Get the data item for this position
        Hospital hospital = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hospital_list_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(.name);
        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;*/
        return null;
    }
}
