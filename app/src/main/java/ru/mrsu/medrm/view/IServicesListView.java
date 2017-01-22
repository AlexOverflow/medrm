package ru.mrsu.medrm.view;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ru.mrsu.medrm.adapter.ServiceArrayAdapter;
import ru.mrsu.medrm.model.OrderBuilder;

public interface IServicesListView {
    ServiceArrayAdapter getListServicesAdapter();
    OrderBuilder getOrderBuilder();
}
