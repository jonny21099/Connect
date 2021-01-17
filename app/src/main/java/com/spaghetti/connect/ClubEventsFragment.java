package com.spaghetti.connect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ClubEventsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.club_eventsview, container, false);

        TextView clubEmail = (TextView) v.findViewById(R.id.profile_club_email);
        TextView clubDes = (TextView) v.findViewById(R.id.profile_club_description
        );
        clubEmail.setText(getArguments().getString("em"));
        clubDes.setText(getArguments().getString("ds"));

        return v;
    }

    public static ClubEventsFragment newInstance(String email, String des) {

        ClubEventsFragment  f = new ClubEventsFragment();
        Bundle b = new Bundle();
        b.putString("em", email);
        b.putString("ds", des);
        f.setArguments(b);
        return f;
    }
}
