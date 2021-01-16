package com.spaghetti.connect.mainFragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.spaghetti.connect.R;

import java.io.File;
import java.io.IOException;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profilePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profilePage extends Fragment {

    private FirebaseFirestore db;
    private String Username;
    private String FirstName;
    private String LastName;
    private String Email;
    private String uid;
    private TextView userName;
    private TextView firstName;
    private TextView lastName;
    private TextView email;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public profilePage() {
        // Required empty public constructo
    }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param Username Parameter 1.
         * @param FirstName Parameter 2.
         * @return A new instance of fragment page4.
         */
    // TODO: Rename and change types and number of parameters
    public static profilePage newInstance(String Username, String FirstName) {
        profilePage fragment = new profilePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, Username);
        args.putString(ARG_PARAM2, FirstName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profilepage, container, false);
        db = FirebaseFirestore.getInstance();
        initUIMap(root);
        setupUserData();
        displayData();
        return root;
    }
    public void initUIMap(final View root){
        userName = (TextView) root.findViewById(R.id.profile_username);
        firstName = (TextView) root.findViewById(R.id.profile_firstName);
        lastName = (TextView) root.findViewById(R.id.profile_lastName);
        email = (TextView) root.findViewById(R.id.profile_email);
    }

    public void setupUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Name, email and uid
                uid = profile.getUid();
//                Username = profile.getDisplayName();
//                Email = profile.getEmail();
            }

        }
    }

    public void displayData(){
        DocumentReference userRef = db.collection("UserProfile").document("hBegFMYKgMJEkitE9GdF");
        userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//
//                    if (document.exists()) {
//                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());
//                    } else {
//                        Log.d("TAG", "No such document");
//                    }
                    DocumentSnapshot doc = task.getResult();
                    Username = (doc.get("UserName")).toString();
                    Email = (doc.get("Email")).toString();
                    FirstName = (doc.get("FirstName")).toString();
                    LastName = (doc.get("LastName")).toString();
                    }

                    //show information
                    userName.setText(Username);
                    email.setText(Email);
                    firstName.setText(FirstName);
                    lastName.setText(LastName);
                }
        });
    }
}