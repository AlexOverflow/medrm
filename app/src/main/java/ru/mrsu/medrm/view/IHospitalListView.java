package ru.mrsu.medrm.view;


import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ru.mrsu.medrm.adapter.HospitalArrayAdapter;
import ru.mrsu.medrm.model.Hospital;


public interface IHospitalListView {
    HospitalArrayAdapter getAdapterHospitals();
}

