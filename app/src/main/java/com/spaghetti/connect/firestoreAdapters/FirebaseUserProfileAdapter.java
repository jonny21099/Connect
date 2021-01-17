package com.spaghetti.connect.firestoreAdapters;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirebaseUserProfileAdapter {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseUserProfileAdapter() {

    }

    public void createNewUser(String email) {
        Map<String, Object> data = new HashMap<>();
        data.put("bookmark", Arrays.asList());
        data.put("subscription", Arrays.asList());
        db.collection("UserProfile").document(email).set(data);
    }
}
