package com.spaghetti.connect.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class ObservableArrayList<T> extends Observable implements Serializable {
    private ArrayList<T> list;

    public ObservableArrayList(){
        list = new ArrayList<>();
    }

    public void notifyChange(){
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<T> getList(){
        return list;
    }

    public void add(T item){
        list.add(item);
    }
}