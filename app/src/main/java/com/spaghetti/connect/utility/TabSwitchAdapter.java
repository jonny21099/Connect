package com.spaghetti.connect.utility;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.spaghetti.connect.ClubDetailsFragment;
import com.spaghetti.connect.ClubEventsFragment;
import com.spaghetti.connect.mainFragments.userprofilePage;

public class TabSwitchAdapter extends FragmentStateAdapter {

    public TabSwitchAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new userprofilePage();
            case 1:
                return ClubEventsFragment.newInstance("123.email.com", "123456");
            default:
                return ClubEventsFragment.newInstance("123.email.com a", "123456");
        }
//        throw new RuntimeException("Catastrophic error");
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
