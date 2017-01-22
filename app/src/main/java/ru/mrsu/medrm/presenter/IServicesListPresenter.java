package ru.mrsu.medrm.presenter;


import ru.mrsu.medrm.adapter.ServiceArrayAdapter;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.model.Service;

public interface IServicesListPresenter {
    void setServicesList(ServiceArrayAdapter adapter);
    void prepareOrder(OrderBuilder builder, Service service);
}
