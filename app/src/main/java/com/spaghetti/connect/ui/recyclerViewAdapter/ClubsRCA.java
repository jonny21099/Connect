package com.spaghetti.connect.ui.recyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.card.MaterialCardView;
import androidx.recyclerview.widget.RecyclerView;

import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Club;

import java.util.ArrayList;

public class ClubsRCA extends RecyclerView.Adapter<ClubsRCA.PostViewHolder> {

    ArrayList<Club> data;

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView layout;
        ImageView image;
        TextView description;
        TextView name;

        PostViewHolder(View requestView) {
            super(requestView);
            layout = requestView.findViewById(R.id.postViewHolderLayout);
            image = requestView.findViewById(R.id.postViewHolderImage);
            name = requestView.findViewById(R.id.postTitle);
            description = requestView.findViewById(R.id.postDesc);
        }
    }

    public ClubsRCA(ArrayList<Club> data) {
        this.data = data;
    }

    @Override
    public ClubsRCA.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.postviewholder, parent, false);
        return new ClubsRCA.PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsRCA.PostViewHolder holder, int position) {
        Club c = data.get(position);

        holder.name.setText(c.getName());
        holder.image.setImageBitmap(c.getImage());
        holder.description.setText(c.getDescription());

        holder.layout.setOnClickListener(v -> {
            // TODO
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

