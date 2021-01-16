package com.spaghetti.connect.mainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userprofilePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userprofilePage extends Fragment {

    private FirebaseFirestore db;
    public String Username;
    public String FirstName;
    public String LastName;
    public String Email;
    public String uid;
    private TextView userName;
    private TextView firstName;
    private TextView lastName;
    private TextView email;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public userprofilePage() {
        // Required empty public constructo
    }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment page4.
         */
    // TODO: Rename and change types and number of parameters
    public static bookmarkPage newInstance(String param1, String param2) {
        bookmarkPage fragment = new bookmarkPage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_userprofilepage, container, false);
        db = FirebaseFirestore.getInstance();

        initUIMap(view);
        displayData();

        //show information
//        Log.d("123", "print:"+Email);

        return view;
    }
    public void initUIMap(View view){
        userName = (TextView) view.findViewById(R.id.profile_username);
        firstName = (TextView) view.findViewById(R.id.profile_firstName);
        lastName = (TextView) view.findViewById(R.id.profile_lastName);
        email = (TextView) view.findViewById(R.id.profile_email);
    }


    public void displayData(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Name, email and uid
                uid = profile.getUid();
//                Username = profile.getDisplayName();
//                Email = profile.getEmail();
            }

        }
        db = FirebaseFirestore.getInstance();
        DocumentReference userRef = db.collection("UesrProfile").document(uid);
        userRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot doc = task.getResult();
                if (doc.exists()) {
                    Username = doc.getString("UserName");
                    Email = doc.getString("Email");
                    FirstName = doc.getString("FirstName");
                    LastName = doc.getString("LastName");
                    //set the Text view
                    userName.setText(Username);
                    email.setText(Email);
                    firstName.setText(FirstName);
                    lastName.setText(LastName);
                } else {
                    Log.d("TAG", "No such document");
                }
            }
        });

    }
}