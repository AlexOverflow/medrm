package ru.mrsu.medrm.view;

import android.widget.ArrayAdapter;

import ru.mrsu.medrm.model.OrderBuilder;

public interface ITimeOrderSelectionView {

    ArrayAdapter<String> getArrayStringAdapter();
    OrderBuilder getOrderBuilder();

}
