package com.spaghetti.connect.firestoreAdapters;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Observable;

/** example
 *
 */
public class FirebaseProfileAdapter {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseProfileAdapter() {

    }

    public void RetrieveProfile(String id, Observable profile) {
        // use id to get document from firestore
        // using data from document to complete profile
        // call profile.setChanged() and profile.notifyObserver()
    }
}
