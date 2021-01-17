package com.spaghetti.connect.firestoreAdapters;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.spaghetti.connect.data.Post;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

import androidx.annotation.NonNull;

/** example
 *
 */
public class FirebaseProfileAdapter {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    Boolean isApproved;
    public FirebaseProfileAdapter() {

    }

    public void RetrieveProfile(String id, Observable profile) {
        // use id to get document from firestore
        // using data from document to complete profile
        // call profile.setChanged() and profile.notifyObserver()
    }

    public ArrayList<Post> getPosts(){
        // returns all the posts in the database

        ArrayList<Post> allPosts = new ArrayList();

        //query the database for all the events
        db.collection("Posts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){

                                // get all the attributes for Post class from the database
                                String id = documentSnapshot.getId();
                                String title = documentSnapshot.get("Title").toString();
                                String club = documentSnapshot.get("Club").toString();
                                String content = documentSnapshot.get("Content").toString();
                                Bitmap image = (Bitmap) documentSnapshot.get("Image");

                                // create a new Post object of the Post in the database
                                Post post = new Post(id, title, club, content, image);
                                allPosts.add(post);


                            }
                        }
                    }
                });

        return allPosts;
    }

    public ArrayList<Post> checkPost (String club, Boolean isClub, ArrayList<Post> allPosts){
        // checks to see if the post should be displayed

        ArrayList<Post> approvedPosts = new ArrayList<Post>();
        Post currentPost;

        for (int i = 0; i < allPosts.size(); i++){
            currentPost = allPosts.get(i);

            if (isClub == true) {
                if (club == currentPost.getClub() ){
                    approvedPosts.add(currentPost);
                }
            } else {

            }
        }

        return approvedPosts;

    }
}
