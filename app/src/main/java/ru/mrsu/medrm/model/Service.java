package ru.mrsu.medrm.model;


public class Service {

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
