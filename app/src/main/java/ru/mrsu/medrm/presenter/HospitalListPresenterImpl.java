package ru.mrsu.medrm.presenter;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import ru.mrsu.medrm.adapter.HospitalArrayAdapter;
import ru.mrsu.medrm.model.Hospital;
import ru.mrsu.medrm.view.IHospitalListView;

public class HospitalListPresenterImpl implements IHospitalListPresenter {

    private IHospitalListView view;
    private final String FIREBASE_ENTITY_NAME = "hospital";

    public HospitalListPresenterImpl(IHospitalListView view){
        this.view = view;
    }


    @Override
    public List<Hospital> getHospitalsListList() {
        ArrayList<Hospital> hospitals = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child(FIREBASE_ENTITY_NAME).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      List<Hospital> hospitals = new ArrayList<Hospital>();
                        int i = 0;
                       for(DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()){
                            Hospital hospital = dataSnapshot.child(Integer.toString(i)).getValue(Hospital.class);
                            hospitals.add(hospital);
                            Log.v("firebase", hospital.toString());
                           view.getAdapterHospitals().add(hospital);
                           i++;
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("firebase", "ERROR");
                    }
                }
        );
        return null;
    }
}
