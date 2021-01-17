package com.spaghetti.connect.mainFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.spaghetti.connect.R;
import com.spaghetti.connect.data.ObservableArrayList;
import com.spaghetti.connect.data.Post;
import com.spaghetti.connect.firebaseAuth.AuthHelper;
import com.spaghetti.connect.firestoreAdapters.FirebaseBookmarkAdapter;
import com.spaghetti.connect.firestoreAdapters.FirebaseUserProfileAdapter;
import com.spaghetti.connect.ui.recyclerViewAdapter.BookmarkRvViewAdapter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
        ArrayList<Post> bookmarks = new ArrayList<>();
        bookmarkedPostAdapter = new BookmarkRvViewAdapter(bookmarks);

        // get all user's bookmark

        FirebaseUserProfileAdapter FUA = new FirebaseUserProfileAdapter();
        FirebaseBookmarkAdapter FBA = new FirebaseBookmarkAdapter();

        ObservableArrayList<String> bookmarkRefs = new ObservableArrayList<>();
        Observer onBookmarkRetrieved = (o, arg) -> {
            for (String postId : bookmarkRefs.getList()) {
                Post p = new Post();
                Observer onPostRetrieved = new Observer() {
                    @Override
                    public void update(Observable o, Object arg) {
                        bookmarks.add(p);
                        ((BookmarkRvViewAdapter) bookmarkedPostAdapter).update();
                    }
                };
                p.addObserver(onPostRetrieved);

                FBA.getPost(postId, p);
            }
        };
        bookmarkRefs.addObserver(onBookmarkRetrieved);
        FUA.getUserBookmarks(AuthHelper.getUserEmail(FirebaseAuth.getInstance()), bookmarkRefs);


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bookmarkpage, container, false);

        bookmarkedPostRcView = view.findViewById(R.id.bookmarkMainRcView);
        bookmarkedPostLayoutManager = new LinearLayoutManager(c);
        bookmarkedPostRcView.setLayoutManager(bookmarkedPostLayoutManager);
        bookmarkedPostRcView.setAdapter(bookmarkedPostAdapter);

        return view;
    }

}