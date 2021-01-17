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

public class ClubsRCA extends RecyclerView.Adapter<ClubsRCA.ClubViewHolder> {

    ArrayList<Club> data;

    public static class ClubViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView layout;
        ImageView image;
        TextView description;
        TextView name;

        ClubViewHolder(View requestView) {
            super(requestView);
            layout = requestView.findViewById(R.id.clubViewHolderLayout);
            image = requestView.findViewById(R.id.clubViewHolderImage);
            name = requestView.findViewById(R.id.clubName);
            description = requestView.findViewById(R.id.clubDesc);
        }
    }

    public ClubsRCA(ArrayList<Club> data) {
        this.data = data;
    }

    @Override
    public ClubsRCA.ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubviewholder, parent, false);
        return new ClubsRCA.ClubViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubsRCA.ClubViewHolder holder, int position) {
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

