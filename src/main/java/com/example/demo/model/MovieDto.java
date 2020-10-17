package com.example.demo.model;

public class MovieDto {
    public MovieDto(String name, String popularity, String available, String price) {
        this.name = name;
        this.popularity = popularity;
        this.available = available;
        this.price = price;
    }

    public MovieDto() {
    }

    private String name;
    private String popularity;
    private String available;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}