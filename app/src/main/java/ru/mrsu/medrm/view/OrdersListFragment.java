package ru.mrsu.medrm.view;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.mrsu.medrm.MenuActivity;
import ru.mrsu.medrm.R;
import ru.mrsu.medrm.adapter.OrderArrayAdapter;
import ru.mrsu.medrm.model.Order;
import ru.mrsu.medrm.presenter.IOrdersListPresenter;
import ru.mrsu.medrm.presenter.OrdersListPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersListFragment extends ListFragment  implements IOrdersListView {

    private OrderArrayAdapter adapter;
    private IOrdersListPresenter presenter;



    public OrdersListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new OrdersListPresenter(this);
        ArrayList<Order> orders = new ArrayList<>();
        OrderArrayAdapter adapter = new OrderArrayAdapter(getActivity(), orders);
        presenter.setOrdersArrayList(adapter);
        setListAdapter(adapter);
    }

    @Override
    public OrderArrayAdapter getOrdersArrayAdapter() {
        return adapter;
    }

    @Override
    public void onListItemClick(ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
