package entity;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class CD implements Serializable {

    private String id;
    private String collection;
    private String type;
    private String title;
    private double price;
    private int yearRelease;

    public CD() {
    }

    public CD(String id, String collection, String type, String title, double price, int yearRelease) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.yearRelease = yearRelease;
    }

    public String getId() {
        return id;
    }

    public String getCollection() {
        return collection;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }
    
}
