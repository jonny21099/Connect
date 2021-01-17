package com.spaghetti.connect.firestoreAdapters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.data.ObservableArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    public void getUserBookmarks(String email, ObservableArrayList<String> reference) {
        db.collection("UserProfile").document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot ds = task.getResult();

                    List<String> bookmarks = (List<String>) ds.get("bookmark");

                    reference.clear();

                    for (String postRef : bookmarks) {
                        reference.add(postRef);
                    }

                    reference.notifyChange();
                }
            }
        });
    }
}
