package ru.mrsu.medrm.presenter;


import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.adapter.DoctorsArrayAdapter;
import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.firebase.FirebaseTreeNode;
import ru.mrsu.medrm.model.Doctor;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.view.IDoctorsListView;
import ru.mrsu.medrm.view.IServicesListView;

public class DoctorsListPresenter implements IDoctorsListPresenter {

    private IDoctorsListView view;
    private FireBaseDataStorage<Doctor> doctorStorage;

    public DoctorsListPresenter(IDoctorsListView view){
        this.view = view;
        doctorStorage = new FireBaseDataStorage<>(Doctor.class);
    }

    @Override
    public void orderPrepare(OrderBuilder orderBuilder, Doctor doctor) {
        orderBuilder.setDoctorName(doctor.getName());
    }

    private List<String> createDatabaseTree(){
        OrderBuilder builder = view.getOrderBuilder();
        List<String> tree = new LinkedList<>();
        tree.add(FirebaseTreeNode.DOCTORS_SERVICE.toString());
        tree.add(builder.getHospitalTitle());
        tree.add(builder.getServiceTitle());
        return tree;
    }

    @Override
    public void setDoctorsList(DoctorsArrayAdapter adapter) {
        doctorStorage.addContentFromFireBase(adapter, createDatabaseTree());
    }
}
