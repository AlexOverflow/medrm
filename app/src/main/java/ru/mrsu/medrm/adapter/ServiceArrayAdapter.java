package ru.mrsu.medrm.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.model.Service;

public class ServiceArrayAdapter extends ArrayAdapter<Service> {

    public ServiceArrayAdapter(Context context, ArrayList<Service> service) {
        super(context, 0, service);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Service service = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_list_item, parent, false);
        }
        // Lookup view for data population
        TextView titleTextView = (TextView) convertView.findViewById(R.id.service_title);
        TextView priceTextView = (TextView) convertView.findViewById(R.id.service_price);
        // Populate the data into the template view using the data object
        titleTextView.setText(service.getTitle());
        priceTextView.setText("стоимость: " + service.getPrice() + " руб");
        // Return the completed view to render on screen
        return convertView;
    }
}
