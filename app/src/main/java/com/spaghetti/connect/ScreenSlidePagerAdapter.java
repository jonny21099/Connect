package com.spaghetti.connect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ScreenSlidePageFragment1();
            case 1:
                return new ScreenSlidePageFragment2();
            case 2:
                return new ScreenSlidePageFragment3();
            case 3:
                return new ScreenSlidePageFragment4();
        }
        throw new RuntimeException("Catastrophic error");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ScreenSlidePageFragment1 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_homepage, container, false);
        }
    }

    public static class ScreenSlidePageFragment2 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_bookmarkpage, container, false);
        }
    }

    public static class ScreenSlidePageFragment3 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_clubspage, container, false);
        }
    }

    public static class ScreenSlidePageFragment4 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_profilepage, container, false);
        }
    }
}

