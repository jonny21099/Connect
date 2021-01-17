package com.spaghetti.connect;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.spaghetti.connect.data.BinarySignal;
import com.spaghetti.connect.mainFragments.bookmarkPage;
import com.spaghetti.connect.mainFragments.clubProfilePage;
import com.spaghetti.connect.mainFragments.clubsPage;
import com.spaghetti.connect.mainFragments.homePage;
import com.spaghetti.connect.mainFragments.userprofilePage;
import com.spaghetti.connect.utility.userClubProfileAdapter;

import java.util.Observable;
import java.util.Observer;

class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    Context c;

    int ob;
    public ScreenSlidePagerAdapter(FragmentActivity fa, Context c) {
        super(fa);

        this.c = c;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new homePage(c);
            case 1:
                return new bookmarkPage(c);
            case 2:
                return new clubsPage();
            case 3:
                ////to use this
                BinarySignal signal = new BinarySignal();
                Observer observer = new Observer() {
                    @Override
                    public void update(Observable observable, Object o) {
                        Log.d("TAG","test: "+signal.getState());
                    }
                };
                signal.addObserver(observer);
                userClubProfileAdapter tester = new userClubProfileAdapter();
                tester.isClubAccount(signal);
                if (!signal.getState()){
                    return new userprofilePage();
                }else{
                    return new clubProfilePage(c);
                }
        }
        throw new RuntimeException("Catastrophic error");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

