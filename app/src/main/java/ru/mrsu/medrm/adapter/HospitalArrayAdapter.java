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

        Hospital hospital = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hospital_list_item, parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.address);

        titleTextView.setText(hospital.getTitle());
        addressTextView.setText(hospital.getAddress());

        return convertView;
    }
}
