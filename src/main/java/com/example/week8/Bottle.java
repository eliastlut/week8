package com.example.week8;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double price;
    private double size;

    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        price = 1.8;
        size = 0.5;
    }

    public Bottle(String name2, double price2, double size2){
        name = name2;
        price = price2;
        size = size2;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getEnergy(){
        return total_energy;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }
}