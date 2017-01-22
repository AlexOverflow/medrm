package ru.mrsu.medrm.presenter;
import ru.mrsu.medrm.adapter.DoctorsArrayAdapter;
import ru.mrsu.medrm.model.Doctor;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.view.IDoctorsListView;

public interface IDoctorsListPresenter {

     void orderPrepare(OrderBuilder orderBuilder, Doctor doctor);
     void setDoctorsList(DoctorsArrayAdapter adapter);

}
