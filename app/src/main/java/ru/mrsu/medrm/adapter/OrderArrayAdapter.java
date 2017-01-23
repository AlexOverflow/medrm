package ru.mrsu.medrm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.model.Order;


public class OrderArrayAdapter extends ArrayAdapter<Order> {
    public OrderArrayAdapter(Context context, ArrayList<Order> order) {
        super(context, 0, order);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Order order = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.order_list_item, parent, false);
        }

        TextView priceTextView = (TextView) convertView.findViewById(R.id.order_price);
        TextView doctorTextView = (TextView) convertView.findViewById(R.id.order_doctor);

        priceTextView.setText("стоимость: " + order.getPrice() + " руб");
        doctorTextView.setText(order.getDoctor());
        return convertView;
    }
}
