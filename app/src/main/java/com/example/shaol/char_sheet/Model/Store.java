package com.example.shaol.char_sheet.Model;

/**
 * Created by shaol on 6/13/2018.
 */

public class Store {
    private String name;
    private double lat;
    private double lng;

    public Store(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getLat() {return lat;}

    public void setLat(double lat) {this.lat = lat;}

    public double getLng() {return lng;}

    public void setLng(double lng) {this.lng = lng;}
}