package ru.mrsu.medrm.presenter;


import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.adapter.ServiceArrayAdapter;
import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.firebase.FirebaseTreeNode;;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.model.Service;
import ru.mrsu.medrm.view.IServicesListView;


public class ServicesListPresenterImpl implements IServicesListPresenter {

    private final String LOG_TAG = "ServicesListPresenter";

    private IServicesListView view;
    private FireBaseDataStorage<Service> serviceStorage;

    public ServicesListPresenterImpl(IServicesListView view){
        this.view = view;
        serviceStorage = new FireBaseDataStorage<>(Service.class);
    }


    private List<String> createDatabaseTree(){
        OrderBuilder builder = view.getOrderBuilder();
        List<String> nodeList = new LinkedList<>();
        nodeList.add(FirebaseTreeNode.SERVICES.toString());

        Log.v(LOG_TAG, builder.getHospitalTitle());

        nodeList.add(builder.getHospitalTitle());
        return nodeList;

    }

    @Override
    public void setServicesList(ServiceArrayAdapter adapter) {
        serviceStorage.addContentFromFireBase(adapter, createDatabaseTree());
    }

    @Override
    public void prepareOrder(OrderBuilder builder, Service service) {
        builder.setServiceTitle(service.getTitle());
        builder.setServicePrice(service.getPrice());
    }
}
