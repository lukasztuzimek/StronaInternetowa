package com.example.demo.model;

import java.util.List;

public class Client {

    private int id;
    private String name;
    private String surename;
    private Address address;
    private List<String> moviesRented;
    private String pass;

    public Client(int id, String name, String surename, Address address, List<String> moviesRented, String pass) {
        this.id = id;
        this.name = name;
        this.surename = surename;
        this.address = address;
        this.moviesRented = moviesRented;
        this.pass = pass;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getMoviesRented() {
        return moviesRented;
    }

    public void setMoviesRented(List<String> moviesRented) {
        this.moviesRented = moviesRented;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
