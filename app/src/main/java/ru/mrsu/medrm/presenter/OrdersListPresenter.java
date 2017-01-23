package ru.mrsu.medrm.presenter;


import com.google.firebase.auth.FirebaseAuth;

import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.adapter.OrderArrayAdapter;
import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.model.Order;
import ru.mrsu.medrm.view.IOrdersListView;

public class OrdersListPresenter implements IOrdersListPresenter {

    IOrdersListView view;
    FireBaseDataStorage<Order> orderDatStorage;


    public OrdersListPresenter(IOrdersListView view){
        this.view = view;
        orderDatStorage = new FireBaseDataStorage<>(Order.class);
    }


    private List<String> createDatabaseTree(){
        List<String> list = new LinkedList<>();
        list.add("order");
        list.add(FirebaseAuth.getInstance().getCurrentUser().getUid());
        return list;
    }

    @Override
    public void setOrdersArrayList(OrderArrayAdapter adapter) {
         orderDatStorage.addContentFromFireBase(adapter, createDatabaseTree());
    }

}
