package com.example.demo.model;

public class Address {
    public Address(String streetName, String buildingNumber, String flatNumber, String postcode, String city) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.postcode = postcode;
        this.city = city;
    }

    public Address() {
    }

    private String streetName;
    private String buildingNumber;
    private String flatNumber;
    private String postcode;
    private String city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
