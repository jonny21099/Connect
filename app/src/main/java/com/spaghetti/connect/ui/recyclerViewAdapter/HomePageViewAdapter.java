package com.spaghetti.connect.ui.recyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Post;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.View.VISIBLE;

public class HomePageViewAdapter  extends RecyclerView.Adapter<HomePageViewAdapter.PostViewHolder> {

    ArrayList<Post> data;

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView layout;
        ImageView image;
        TextView title;
        TextView content;
        TextView club;
        TextView date;

        Button attend;
        Button bookmark;

        //TODO: I DONT KNOW IF I SHOUDL CHANGE THIS?? WILL THIS CAUSE PROBLEMS???
        PostViewHolder(View requestView) {
            super(requestView);
            image = requestView.findViewById(R.id.postViewHolderImage);
            layout = requestView.findViewById(R.id.postViewHolderLayout);
            title = requestView.findViewById(R.id.postTitle);
            club = requestView.findViewById(R.id.clubName);
            date = requestView.findViewById(R.id.postDate);
            content = requestView.findViewById(R.id.postDesc);
            bookmark = requestView.findViewById(R.id.bookmarkButton);
            attend = requestView.findViewById(R.id.attendButton);
        }
    }

    public HomePageViewAdapter(ArrayList<Post> data) {
        this.data = data;
    }

    @Override
    public HomePageViewAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.postviewholder, parent, false);
        return new HomePageViewAdapter.PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewAdapter.PostViewHolder holder, int position) {
        Post p = data.get(position);

        holder.content.setText(p.getContent());
        holder.title.setText(p.getTitle());
        holder.image.setImageBitmap(p.getImage());
        holder.club.setText(p.getClub());
        holder.date.setText(p.getEventDate().toString());

        // check if it is an announcement or a post
        if (p.isEvent()){
            holder.attend.setVisibility(VISIBLE);
            holder.bookmark.setVisibility(VISIBLE);
        } else {
            holder.attend.setVisibility(View.INVISIBLE);
            holder.bookmark.setVisibility(View.INVISIBLE);
        }
        holder.layout.setOnClickListener(v -> {
            // TODO
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update() {
        if (getItemCount() > 1) {
            data.sort((o1, o2) -> o2.getCreationTime().compareTo(o1.getCreationTime()));
        }
        notifyDataSetChanged();
    }
}
