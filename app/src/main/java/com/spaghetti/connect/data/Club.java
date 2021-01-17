package com.spaghetti.connect.data;

import android.graphics.Bitmap;

import java.util.Observable;

public class Club extends Observable {
    String description;
    String name;
    String email;
    Bitmap image;

    //constructor
    public Club(String name, String email, String description){
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Club(String name, String email, String description, Bitmap image){
        this.name = name;
        this.email = email;
        this.description = description;
        this.image = image;
    }

    //getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //getter and setter for image
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

