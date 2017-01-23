package ru.mrsu.medrm.view;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.adapter.HospitalArrayAdapter;
import ru.mrsu.medrm.firebase.FirebaseTreeNode;
import ru.mrsu.medrm.model.Hospital;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.presenter.HospitalListPresenterImpl;
import ru.mrsu.medrm.presenter.IHospitalListPresenter;

public class HospitalsListActivity extends ListActivity implements IHospitalListView {

    private ListView listView;
    private IHospitalListPresenter presenter;
    private HospitalArrayAdapter adapter;
    private ArrayList<Hospital> hospitals;
    private OrderBuilder orderBuilder;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderBuilder = new OrderBuilder();
        hospitals = new ArrayList<>();
        presenter = new HospitalListPresenterImpl(this);
       // presenter.getHospitalsListList();
        adapter = new HospitalArrayAdapter(this, hospitals);
        presenter.setHospitalsList(adapter);
        listView = getListView();
        setListAdapter(adapter);
    }

    @Override
    public HospitalArrayAdapter getAdapterHospitals() {
        return adapter;
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       Hospital hospital = (Hospital) adapter.getItem(position);
       Intent i = new Intent();
        i.putExtra("hospital", hospital);
        setResult(RESULT_OK, i);
        finish();
    }


}