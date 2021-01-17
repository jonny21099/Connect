package com.spaghetti.connect.utility;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.spaghetti.connect.data.BinarySignal;
import com.spaghetti.connect.data.ObservableArrayList;
import com.spaghetti.connect.firebaseAuth.AuthHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class userClubProfileAdapter {
    //returns true if it's club account, false if its not
    public void isClubAccount(BinarySignal signal) {
        String userEmail = AuthHelper.getUserEmail(FirebaseAuth.getInstance());;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("ClubProfile").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(document.get("email").toString().equals(userEmail)){
                            signal.broadcast(true);
                            return;
                        }
                    }
                    signal.broadcast(false);
                }
            }
        });
    }
}

////to use this
//BinarySignal signal = new BinarySignal();
//    Observer observer = new Observer() {
//        @Override
//        public void update(Observable observable, Object o) {
//            Log.d(TAG,"test: "+signal.getState());
//
//        }
//
//    };
//        signal.addObserver(observer);
//        userClubProfileAdapter tester = new userClubProfileAdapter();
//        tester.isClubAccount(signal);