package com.spaghetti.connect.utility;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.spaghetti.connect.ClubDetailsFragment;
import com.spaghetti.connect.ClubEventsFragment;

public class TabSwitchAdapter extends FragmentStateAdapter {

    Context c;

    public TabSwitchAdapter(FragmentActivity fa, Context c) {
        super(fa);

        this.c = c;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ClubDetailsFragment();
            case 1:
                return new ClubEventsFragment();
        }
        throw new RuntimeException("Catastrophic error");
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
