package com.spaghetti.connect.firebaseAuth;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.spaghetti.connect.LogIn;
import com.spaghetti.connect.data.BinarySignal;

import org.jetbrains.annotations.NotNull;

public class AuthHelper {
    private static final String tag = "AUTH";

    public static void signIn(String email, String password, @NonNull FirebaseAuth FA, BinarySignal signal){
         FA.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
             signal.broadcast(task.isSuccessful());
         });
    }

    public static boolean signedIn(@NonNull FirebaseAuth FA) {
        if (FA.getCurrentUser() == null) {
            Log.d(tag, "NO ACTIVE USER");
            return false;
        } else {
            Log.d(tag, "USER SIGNED IN");
            return true;
        }
    }

    public static String getUserEmail(@NonNull FirebaseAuth FA) {
        return FA.getCurrentUser().getEmail();
    }

    public static void signOut(@NonNull FirebaseAuth FA) {
        FA.signOut();
        LogIn login;
    }

    public static void register(String email, String password, @NonNull FirebaseAuth FA, BinarySignal signal) {
        FA.createUserWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            signal.broadcast(true);
        }).addOnFailureListener(e -> {
            Log.d("Register", e.toString());
            signal.broadcast(false);
        });
    }

    public static void passwordReset(String email, @NotNull FirebaseAuth FA, BinarySignal signal) {
        FA.sendPasswordResetEmail(email).addOnSuccessListener(aVoid -> {
            signal.broadcast(true);
        }).addOnFailureListener(e -> {
            Log.d(tag, e.toString());
            signal.broadcast(false);
        });
    }
}
