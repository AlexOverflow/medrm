package ru.mrsu.medrm.model;

import java.io.Serializable;

public class Schedule implements Serializable {

    private String startTime;
    private String endTime;
    private String time;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
