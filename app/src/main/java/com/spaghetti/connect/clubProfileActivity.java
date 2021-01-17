package com.spaghetti.connect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.spaghetti.connect.mainFragments.clubProfilePage;
import com.spaghetti.connect.utility.TabSwitchAdapter;

public class clubProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private TabSwitchAdapter tabSwitchAdapter;
    private ViewPager2 vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_clubprofilepage);

        String[] titles = new String[]{"Details", "Events"};
        tabLayout = findViewById(R.id.tabMode);
        vp = findViewById(R.id.profile_club_pager);
        tabSwitchAdapter = new TabSwitchAdapter(this);
        vp.setAdapter(tabSwitchAdapter);
        new TabLayoutMediator(tabLayout, vp,(tab, position) -> tab.setText(titles[position])).attach();
    }
}
