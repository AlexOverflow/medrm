package ru.mrsu.medrm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ru.mrsu.medrm.view.HospitalsListFragment;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MenuActivity.class);

        FirebaseDatabase.getInstance().getReference().child("hospital").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.v("firebase", Long.toString(dataSnapshot.getChildrenCount()));
                        Log.v("firebase", dataSnapshot.toString());
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("firebase", "ERROR");
                    }
                }
        );
        startActivity(intent);
    }
}
