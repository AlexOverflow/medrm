package ru.mrsu.medrm.model;


import java.io.Serializable;

public class Service implements Serializable {

    private String title;
    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
