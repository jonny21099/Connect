package com.spaghetti.connect.ui.recyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Post;

import java.util.ArrayList;

public class BookmarkRCA extends RecyclerView.Adapter<BookmarkRCA.PostViewHolder> {

    ArrayList<Post> data;

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView layout;
        ImageView image;
        TextView title;
        TextView content;

        PostViewHolder(View requestView) {
            super(requestView);
            image = requestView.findViewById(R.id.postViewHolderImage);
            layout = requestView.findViewById(R.id.postViewHolderLayout);
            title = requestView.findViewById(R.id.postTitle);
            content = requestView.findViewById(R.id.clubName);
        }
    }

    public BookmarkRCA(ArrayList<Post> data) {
        this.data = data;
    }

    @Override
    public BookmarkRCA.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.postviewholder, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post p = data.get(position);

        holder.content.setText(p.getContent());
        holder.title.setText(p.getTitle());
        holder.image.setImageBitmap(p.getImage());

        holder.layout.setOnClickListener(v -> {
            // TODO
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
