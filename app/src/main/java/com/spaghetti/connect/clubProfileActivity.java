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


        tabLayout = findViewById(R.id.tabMode);
        vp = findViewById(R.id.profile_club_pager);
        tabSwitchAdapter = new TabSwitchAdapter(this, clubProfileActivity.this);
        vp.setAdapter(tabSwitchAdapter);

        new TabLayoutMediator(tabLayout, vp,(tab, position) -> {
            switch (position){
                case 0:
                    tab.setCustomView(R.layout.club_cardview);
                    break;
                case 1:
                    tab.setCustomView(R.layout.club_eventsview);
            }
        }).attach();
    }
}
