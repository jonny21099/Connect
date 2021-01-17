package com.spaghetti.connect.data;

import java.util.Observable;

public class BinarySignal extends Observable {

    private boolean state;

    public boolean getState() {
        return state;
    }

    public void broadcast(boolean signal) {
        state = signal;

        setChanged();
        notifyObservers();
    }
}
