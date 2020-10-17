package com.example.demo.model;

public class Movie {
    public Movie(int id, String title, double popularity, int available) {
        this.id = id;
        this.title = title;
        this.popularity = popularity;
        this.available = available;
    }

    public Movie() {
    }

    private int id;
    private String title;
    private double popularity;
    private int available;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
