package ru.mrsu.medrm.view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.presenter.IHospitalListPresenter;

public class HospitalsListFragment extends Fragment {

    ListView listView;
    IHospitalListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hospitals_list, container,false);

        return v;
    }
}