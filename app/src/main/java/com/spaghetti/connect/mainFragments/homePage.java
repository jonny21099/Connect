package com.spaghetti.connect.mainFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Club;
import com.spaghetti.connect.data.ObservableArrayList;
import com.spaghetti.connect.data.Post;
import com.spaghetti.connect.firestoreAdapters.FirebaseProfileAdapter;
import com.spaghetti.connect.ui.recyclerViewAdapter.BookmarkRvViewAdapter;
import com.spaghetti.connect.ui.recyclerViewAdapter.HomePageViewAdapter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class homePage extends Fragment {

    private View view;
    private Context context;

    RecyclerView homepagePostRcView;
    RecyclerView.Adapter homepagePostAdapter;
    RecyclerView.LayoutManager homepageLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homePage(Context context) {
        // Required empty public constructor
        this.context = context;
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

        FirebaseProfileAdapter firebaseProfileAdapter = new FirebaseProfileAdapter();
        /*ObservableArrayList<String>  = new ObservableArrayList();

        Observer onHomePageRetrieved = (o, arg) -> {
            for (String in postId: )
        }*/

        ObservableArrayList<Post> observablePostList = new ObservableArrayList();

        Observer OnCompleteLister = new Observer() {
            @Override
            public void update(Observable observable, Object o) {
                ArrayList<Post> homeList = observablePostList.getList();
                homepagePostAdapter = new HomePageViewAdapter(homeList);
                homepagePostRcView.setAdapter(homepagePostAdapter);
            }
        };

        observablePostList.addObserver(OnCompleteLister);
        firebaseProfileAdapter.RetrieveAllPosts(observablePostList);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);

        homepagePostRcView = view.findViewById(R.id.recyclerView);
        homepageLayoutManager = new LinearLayoutManager(context);
        homepagePostRcView.setLayoutManager(homepageLayoutManager);

        return view;
    }
}