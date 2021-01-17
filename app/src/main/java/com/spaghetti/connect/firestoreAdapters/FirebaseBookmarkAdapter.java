package com.spaghetti.connect.firestoreAdapters;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.data.Post;

import org.w3c.dom.Document;

public class FirebaseBookmarkAdapter {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseBookmarkAdapter() {

    }

    public void getPost(String postId, Post p) {
        db.collection("Posts").document(postId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot ds = task.getResult();

                    p.setClub(ds.getString("Club"));
                    p.setContent(ds.getString("Content"));
                    p.setTitle(ds.getString("Title"));
                    p.setId(postId);
                    p.setCreationTime(ds.getDate("Date Created"));
                    p.setEventDate(ds.getDate("Event Date"));
                    p.setEvent(ds.getBoolean("isEvent"));

                    p.mark();
                }
            }
        });
    }
}
