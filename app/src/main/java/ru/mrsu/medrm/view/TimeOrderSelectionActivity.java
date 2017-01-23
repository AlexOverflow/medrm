package ru.mrsu.medrm.view;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import ru.mrsu.medrm.model.OrderBuilder;

public class TimeOrderSelectionActivity extends ListActivity implements ITimeOrderSelectionView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public ArrayAdapter<String> getArrayStringAdapter() {
        return null;
    }

    @Override
    public OrderBuilder getOrderBuilder() {
        return null;
    }
}
