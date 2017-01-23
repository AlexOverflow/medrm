package ru.mrsu.medrm.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderBuilder implements Serializable {
    private String hospitalTitle;
    private String serviceTitle;
    private String servicePrice;
    private String doctorName;
    private String date;

    private Hospital hospital;
    private Service service;
    private Doctor doctor;


    public String getHospitalTitle() {
        return hospitalTitle;
    }

    public void setHospitalTitle(String hospitalTitle) {
        this.hospitalTitle = hospitalTitle;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "OrderBuilder{" +
                "hospitalTitle='" + hospitalTitle + '\'' +
                ", serviceTitle='" + serviceTitle + '\'' +
                ", servicePrice='" + servicePrice + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Order buildOrder() {
        Order order = new Order();
        order.setDoctor(hospital.getAddress());
        order.setDoctor(doctor.getName());
        order.setPrice(service.getPrice());
        SimpleDateFormat format = new SimpleDateFormat("MM:DD:HH:mm:ss");
        order.setDateCreated(format.format(Calendar.getInstance().getTime()));
        return order;
    }
}
