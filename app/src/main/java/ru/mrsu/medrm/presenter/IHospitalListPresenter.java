package ru.mrsu.medrm.presenter;

import ru.mrsu.medrm.adapter.HospitalArrayAdapter;
import ru.mrsu.medrm.model.Hospital;
import ru.mrsu.medrm.model.OrderBuilder;

public interface IHospitalListPresenter {

    void setHospitalsList(HospitalArrayAdapter adapter);
    void orderPrepare(OrderBuilder builder, Hospital hospital);

}
