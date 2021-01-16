package com.spaghetti.connect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.spaghetti.connect.mainFragments.bookmarkPage;
import com.spaghetti.connect.mainFragments.clubsPage;
import com.spaghetti.connect.mainFragments.homePage;
import com.spaghetti.connect.mainFragments.userprofilePage;

class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new homePage();
            case 1:
                return new bookmarkPage();
            case 2:
                return new clubsPage();
            case 3:
                return new userprofilePage();
        }
        throw new RuntimeException("Catastrophic error");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

