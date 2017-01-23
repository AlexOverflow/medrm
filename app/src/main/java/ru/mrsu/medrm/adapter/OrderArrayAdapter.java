package ru.mrsu.medrm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.mrsu.medrm.MenuActivity;
import ru.mrsu.medrm.R;
import ru.mrsu.medrm.model.Order;
import ru.mrsu.medrm.view.OrdersListFragment;


public class OrderArrayAdapter extends ArrayAdapter<Order> {



    public OrderArrayAdapter(Context context, ArrayList<Order> order) {
        super(context, 0, order);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Order order = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.order_list_item2, parent, false);
        }

        TextView hospitalTextView = (TextView) convertView.findViewById(R.id.order_hospital_title);
        TextView doctorTextView = (TextView) convertView.findViewById(R.id.order_doctor);
        TextView priceTextView = (TextView) convertView.findViewById(R.id.order_price);



        hospitalTextView.setText(order.getHospitalTitle());
        doctorTextView.setText(order.getAddress());
        priceTextView.setText("Стоимость: " + order.getPrice() + " руб");

        return convertView;
    }
}
