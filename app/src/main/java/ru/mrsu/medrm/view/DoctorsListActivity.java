package ru.mrsu.medrm.view;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.adapter.DoctorsArrayAdapter;
import ru.mrsu.medrm.model.Doctor;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.presenter.DoctorsListPresenter;
import ru.mrsu.medrm.presenter.IDoctorsListPresenter;

public class DoctorsListActivity extends ListActivity implements IDoctorsListView  {

    private IDoctorsListPresenter presenter;
    private OrderBuilder orderBuilder;
    private DoctorsArrayAdapter adapter;

    private final String LOG_TAG = "DoctorsListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderBuilder = (OrderBuilder) getIntent().getSerializableExtra("order");
        Log.v(LOG_TAG, orderBuilder.toString());
        presenter = new DoctorsListPresenter(this);
        ArrayList<Doctor> doctorList = new ArrayList<>();
        adapter = new DoctorsArrayAdapter(this, doctorList);
        presenter.setDoctorsList(adapter);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Doctor doctor = adapter.getItem(position);
        Intent i = new Intent();
        i.putExtra("order", orderBuilder);
        i.putExtra("doctor", doctor);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public OrderBuilder getOrderBuilder() {
        return orderBuilder;
    }
}
