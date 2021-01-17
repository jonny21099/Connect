package com.spaghetti.connect.mainFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.LogIn;
import com.spaghetti.connect.R;
import com.spaghetti.connect.data.BinarySignal;
import com.spaghetti.connect.firebaseAuth.AuthHelper;
import com.spaghetti.connect.utility.userClubProfileAdapter;

import java.util.Observable;
import java.util.Observer;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userprofilePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userprofilePage extends Fragment {

    private FirebaseAuth currentUser = FirebaseAuth.getInstance();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: R ename and change types of parameters
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
    public static userprofilePage newInstance(String param1, String param2) {
        userprofilePage fragment = new userprofilePage();
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
        Button logout = view.findViewById(R.id.logoutBtn);

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AuthHelper.signOut(currentUser);
                Intent a = new Intent(getActivity(), LogIn.class);
                startActivity(a);
            }

        });

        //show information
//        Log.d("123", "print:"+Email);

        return view;
    }
}