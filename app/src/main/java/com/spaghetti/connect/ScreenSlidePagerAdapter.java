package com.spaghetti.connect;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.spaghetti.connect.mainFragments.bookmarkPage;
import com.spaghetti.connect.mainFragments.clubsPage;
import com.spaghetti.connect.mainFragments.homePage;
import com.spaghetti.connect.mainFragments.profilePage;

class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    Context c;

    public ScreenSlidePagerAdapter(FragmentActivity fa, Context c) {
        super(fa);

        this.c = c;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new homePage();
            case 1:
                return new bookmarkPage(c);
            case 2:
                return new clubsPage();
            case 3:
                return new profilePage();
        }
        throw new RuntimeException("Catastrophic error");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

