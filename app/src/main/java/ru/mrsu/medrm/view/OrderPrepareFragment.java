package ru.mrsu.medrm.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import ru.mrsu.medrm.R;
import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.model.Doctor;
import ru.mrsu.medrm.model.Hospital;
import ru.mrsu.medrm.model.Order;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.model.Service;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderPrepareFragment extends Fragment {

    public OrderPrepareFragment() {}

    private OrderBuilder orderBuilder;

    private final int HOSPITAL_ACTIVITY_CODE = 0;
    private final int SERVICE_ACTIVITY_CODE = 1;
    private final int DOCOTOR_ACTIVITY_CODE = 2;
    private final int DATE_ACTIVITY_CODE = 3;
    private final int TIME_ACTIVITY_CODE = 4;

    private EditText hospitalEditText;
    private EditText serviceEditText ;
    private EditText doctorEditText;
    private EditText dateEditText;
    private EditText timeEditText;
    private Button finishButton;
    private ArrayList<EditText> editTexts;

    private FireBaseDataStorage<Order> orderStorage;

    private SimpleDateFormat dateFormatter;


    private FragmentManager manager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_prepare, container, false);
        orderStorage = new FireBaseDataStorage<>(Order.class);
        orderBuilder = new OrderBuilder();
        hospitalEditText = (EditText) v.findViewById(R.id.hospital_place);
        serviceEditText = (EditText) v.findViewById(R.id.service_place);
        doctorEditText = (EditText) v.findViewById(R.id.doctor_place);
        dateEditText = (EditText) v.findViewById(R.id.date_place);
        timeEditText = (EditText) v.findViewById(R.id.time_place);
        finishButton = (Button)  v.findViewById(R.id.finish_button);

        dateFormatter = new SimpleDateFormat("dd-MM-HH-MM", Locale.US);

        initEditsArray();
        hospitalEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(getActivity(), HospitalsListActivity.class);
                    startActivityForResult(i, HOSPITAL_ACTIVITY_CODE);

            }
        });

        serviceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(isEmpty(hospitalEditText.getText().toString()))){
                    Log.v("Firebase", "NOOOOOOOOOOOOOOOOOOT");
                    Intent i = new Intent(getActivity(), ServicesListActivity.class);
                    i.putExtra("order", orderBuilder);
                    startActivityForResult(i, SERVICE_ACTIVITY_CODE);
                }
            }
        });

        doctorEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(isEmpty(serviceEditText.getText().toString()))){
                    Intent i = new Intent(getActivity(), DoctorsListActivity.class);
                    i.putExtra("order", orderBuilder);
                    startActivityForResult(i, DOCOTOR_ACTIVITY_CODE);
                }
            }
        });

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar newDate = Calendar.getInstance();
                                newDate.set(year, monthOfYear, dayOfMonth);
                                orderBuilder.setDate(dateFormatter.format(newDate.getTime()));
                                dateEditText.setText(dateFormatter.format(newDate.getTime()));
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.setMinDate(now);

                dpd.show(getActivity().getFragmentManager(), "DatePicker");
                orderBuilder.setDate(dateEditText.getText().toString());
                finishButton.setEnabled(true);
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new LinkedList<String>();
                list.add("order");
                list.add(dateFormatter.format(Calendar.getInstance().getTime()));
                Order order;
                order =  orderBuilder.buildOrder();
                orderStorage.writeObject(order, list);

            }
        });

        return  v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}

        switch(requestCode){
            case HOSPITAL_ACTIVITY_CODE:
                Hospital hospital = (Hospital) data.getSerializableExtra("hospital");
                orderBuilder.setHospital(hospital);
                eraseEditField(HOSPITAL_ACTIVITY_CODE);
                hospitalEditText.setText(hospital.getTitle());
                finishButton.setEnabled(false);
                break;
            case SERVICE_ACTIVITY_CODE:
                Service service = (Service) data.getSerializableExtra("service");
                orderBuilder.setService(service);
                eraseEditField(SERVICE_ACTIVITY_CODE);
                serviceEditText.setText(service.getTitle());
                finishButton.setEnabled(false);
                break;
            case DOCOTOR_ACTIVITY_CODE:
                Doctor doctor = (Doctor) data.getSerializableExtra("doctor");
                orderBuilder.setDoctor(doctor);
                eraseEditField(DOCOTOR_ACTIVITY_CODE);
                doctorEditText.setText(doctor.getName());
                finishButton.setEnabled(false);
                break;
        }


    }

    boolean isEmpty(String str){
       if("".equals(str)){
           return true;
       }
        return false;
    }

    private void initEditsArray() {
        editTexts = new ArrayList<>();
        editTexts.add(hospitalEditText);
        editTexts.add(serviceEditText);
        editTexts.add(doctorEditText);
        editTexts.add(dateEditText);
        editTexts.add(timeEditText);
    }

    private void eraseEditField(int code){
        for(int i = code + 1; i < editTexts.size(); i++){
            if(!(isEmpty(editTexts.get(i).getText().toString()))){
                editTexts.get(i).setText("");
            }
        }
    }
}
