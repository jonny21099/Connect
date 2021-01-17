package com.spaghetti.connect.data;

import android.graphics.Bitmap;

import java.util.Observable;

public class Post extends Observable {
    String id;
    String title;
    String content;
    String club;
    Bitmap image;
    String date;

    public Post(String id, String title, String club, String content, Bitmap image, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.club = club;
        this.image = image;
        this.date = date;
    }


    public Post(String id, String title, String club, String content, String Date) {
        this.id = id;
        this.title = title;
        this.club = club;
        this.content = content;
        this.date = date;
    }

    public void mark() {
        setChanged();
        notifyObservers();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setClub(String club) { this.club = club; }

    public String getClub() { return club;}

    public void setDate(String date) { this.date = date;}

    public String getDate() { return date; }
    }
}
