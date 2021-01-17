package com.spaghetti.connect.ui.recyclerViewAdapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.card.MaterialCardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.spaghetti.connect.R;
import com.spaghetti.connect.data.Club;
import com.spaghetti.connect.dialogs.joinClubDialog;
import com.spaghetti.connect.firebaseAuth.AuthHelper;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class ClubsRCA extends RecyclerView.Adapter<ClubsRCA.ClubViewHolder> {
    ArrayList<Club> data;
    public ClubsRCA(ArrayList<Club> data) {
        this.data = data;
    }

    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubviewholder, parent, false);
        return new ClubViewHolder(view);
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

    public static class ClubViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            Button btn = requestView.findViewById(R.id.moreInfoBtn);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FirebaseAuth currentUser = FirebaseAuth.getInstance();
            final String[] userEmail = new String[1];
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Confirmation");
            builder.setMessage("Are you sure you want to join " + name.getText() + "?");
            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which){
                    //TODO connect to firebase and add club to user
                    if(AuthHelper.signedIn(currentUser)){
                        userEmail[0] = AuthHelper.getUserEmail(currentUser);
                    }
                    DocumentReference userRef = db.collection("UserProfile").document(userEmail[0]);
                    userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                DocumentSnapshot doc = task.getResult();
                            }
                        }
                    });
                    userRef.update("subscription", FieldValue.arrayUnion(name.getText())).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                            }
                        }
                    });
                }
            });
            builder.setPositiveButton("Cancel",null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}

