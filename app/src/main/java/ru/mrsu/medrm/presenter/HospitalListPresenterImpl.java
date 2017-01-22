package ru.mrsu.medrm.presenter;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ru.mrsu.medrm.adapter.HospitalArrayAdapter;
import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.firebase.FirebaseTreeNode;
import ru.mrsu.medrm.model.Hospital;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.view.IHospitalListView;

public class HospitalListPresenterImpl implements IHospitalListPresenter {

    private final String LOG_TAG = "HospitalListPresenter";

    private IHospitalListView view;
    private FireBaseDataStorage<Hospital> hospitalStorage;

    public HospitalListPresenterImpl(IHospitalListView view){
        this.view = view;
        hospitalStorage = new FireBaseDataStorage<>(Hospital.class);
        createTreeNodeList();
    }



    private List<String> createTreeNodeList() {
        List<String> treeNodeList = new LinkedList<>();
        treeNodeList.add(FirebaseTreeNode.HOSPITALS.toString());

        Log.v(LOG_TAG, FirebaseTreeNode.HOSPITALS.toString());

        return treeNodeList;
    }

    public void setHospitalsList(HospitalArrayAdapter adapter){
        hospitalStorage.addContentFromFireBase(adapter, createTreeNodeList());
    }

    @Override
    public void orderPrepare(OrderBuilder builder, Hospital hospital) {
        Log.v(LOG_TAG, hospital.getTitle());
        builder.setHospitalTitle(hospital.getTitle());
    }
}
