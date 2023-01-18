package com.example.mycovidcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListLokasi {
    public String color;
    public String name;
    public String city;

    public ListLokasi(String color, String name, String city, String status) {
        this.color = color;
        this.name = name;
        this.city = city;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}