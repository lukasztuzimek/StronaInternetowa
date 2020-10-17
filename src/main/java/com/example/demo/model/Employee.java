package com.example.demo.model;


public class Employee {
    private String firstName;
    private String sureName;
    private int salary;
    private Address address;

    public Employee(String firstName, String sureName, int salary, Address address) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.salary = salary;
        this.address = address;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
