package ru.mrsu.medrm.presenter;


import android.widget.ArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ru.mrsu.medrm.firebase.FireBaseDataStorage;
import ru.mrsu.medrm.firebase.FirebaseTreeNode;
import ru.mrsu.medrm.model.OrderBuilder;
import ru.mrsu.medrm.model.Schedule;
import ru.mrsu.medrm.view.ITimeOrderSelectionView;

public class TimeOrderSelectionPresenter {

    private ITimeOrderSelectionView view;

    private FireBaseDataStorage<Schedule> scheduleArrayStorage;
    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public TimeOrderSelectionPresenter(ITimeOrderSelectionView view){
        scheduleArrayStorage = new FireBaseDataStorage<>(Schedule.class);
        this.view = view;
    }

    List<String> createDatabaseTree(){
        List<String> list = new LinkedList<>();
        OrderBuilder builder = view.getOrderBuilder();
        list.add(FirebaseTreeNode.SCHEDULE.toString());
        list.add(builder.getService().getTitle());
        list.add(builder.getHospital().getTitle());
        list.add(builder.getService().getTitle());
        list.add(builder.getDoctor().getName());
        return  list;
    }

    public void setArrayTimeContent(ArrayAdapter<String> adapter) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        scheduleArrayStorage.setSingleObject(schedules, createDatabaseTree());
        Schedule schedule = schedules.get(0);

    }

}
