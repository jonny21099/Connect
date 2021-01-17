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
import com.spaghetti.connect.RecyclerViewAdapter;
import com.spaghetti.connect.data.Post;
import com.spaghetti.connect.ui.recyclerViewAdapter.BookmarkRCA;

import java.util.ArrayList;

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

        Post p = new Post("Test", "test", "test");
        ArrayList<Post> pp = new ArrayList<>();

        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homepage, container, false);

        homepagePostRcView = view.findViewById(R.id.recyclerView);
        homepageLayoutManager = new LinearLayoutManager(context);
        homepagePostRcView.setLayoutManager(homepageLayoutManager);

        homepagePostAdapter = new BookmarkRCA(pp);
        homepagePostRcView.setAdapter(homepagePostAdapter);

        return view;
    }
}