package com.spaghetti.connect.firestoreAdapters;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.spaghetti.connect.data.ObservableArrayList;
import com.spaghetti.connect.data.Club;

import java.util.Observable;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

/** example
 *
 */
public class FirebaseProfileAdapter {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseProfileAdapter() {

    }

    public void RetrieveAllPosts(){
        DocumentReference userRef = db.collection("Posts").document();
        userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    String title = doc.getString("title");
                    String content = doc.getString("content");
                }
            }
        });
    }

    public void RetrieveAllClubs(ObservableArrayList<Club> clubList){
        db.collection("ClubProfile").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()){
                        String name = document.get("name").toString();
                        String description = document.get("description").toString();
                        String email = document.get("email").toString();
                        Club eachClub = new Club(name, email, description);
                        clubList.add(eachClub);
                    }
                    clubList.notifyChange();
                }
                else{
                    Log.d(TAG, "Error getting documents: ",task.getException());
                }
            }
        });
    }

    public void RetrieveProfile(String id, Observable profile) {
        // use id to get document from firestore
        // using data from document to complete profile
        // call profile.setChanged() and profile.notifyObserver()
    }
}
