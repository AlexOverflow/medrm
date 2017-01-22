package ru.mrsu.medrm.view;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.adapter.ServiceArrayAdapter;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.model.Service;
import ru.mrsu.medrm.presenter.IServicesListPresenter;
import ru.mrsu.medrm.presenter.ServicesListPresenterImpl;

public class ServicesListActivity extends ListActivity implements IServicesListView {

    private ServiceArrayAdapter adapter;
    private IServicesListPresenter presenter;
    private ArrayList<Service> serviceArrayList;
    private OrderBuilder orderBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hospital_services_list);
        orderBuilder = (OrderBuilder) getIntent().getSerializableExtra("order");
        presenter = new ServicesListPresenterImpl(this);
        serviceArrayList = new ArrayList<>();
         adapter = new ServiceArrayAdapter(this, serviceArrayList);
        presenter.setServicesList(adapter);
        setListAdapter(adapter);
    }


    @Override
    public ServiceArrayAdapter getListServicesAdapter() {
        return adapter;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Service service  = (Service) adapter.getItem(position);
        presenter.prepareOrder(orderBuilder, service);
        Intent i = new Intent(this, DoctorsListActivity.class);
        i.putExtra("order", orderBuilder);
        startActivity(i);
    }

    public OrderBuilder getOrderBuilder() {
        return orderBuilder;
    }
}
