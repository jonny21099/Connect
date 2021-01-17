package com.spaghetti.connect.mainFragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Post;
import com.spaghetti.connect.ui.recyclerViewAdapter.BookmarkRCA;

import java.util.ArrayList;

public class bookmarkPage extends Fragment {

    private View view;
    private Context c;

    RecyclerView bookmarkedPostRcView;
    RecyclerView.Adapter bookmarkedPostAdapter;
    RecyclerView.LayoutManager bookmarkedPostLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bookmarkPage(Context c) {
        this.c = c;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Post p = new Post("Test", "test", "test");
        ArrayList<Post> pp = new ArrayList<>();

        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);
        pp.add(p);


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bookmarkpage, container, false);

        bookmarkedPostRcView = view.findViewById(R.id.bookmarkMainRcView);
        bookmarkedPostLayoutManager = new LinearLayoutManager(c);
        bookmarkedPostRcView.setLayoutManager(bookmarkedPostLayoutManager);

        bookmarkedPostAdapter = new BookmarkRCA(pp);
        bookmarkedPostRcView.setAdapter(bookmarkedPostAdapter);


        return view;
    }
}