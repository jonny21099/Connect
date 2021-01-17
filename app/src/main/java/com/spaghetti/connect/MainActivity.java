package com.spaghetti.connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.spaghetti.connect.firebaseAuth.AuthHelper;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 vp;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getBooleanExtra("Initalize User", false)) {
            //TODO get user's name and stuff
        }

        // check auth state
        if (!AuthHelper.signedIn(FirebaseAuth.getInstance())) {
            //TODO change to log in
            //Intent i = new Intent(MainActivity.this, Register.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //startActivity(i);
            //finishAffinity();
        }

        setContentView(R.layout.activity_main);

        // configure viewpager
        vp = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this, MainActivity.this);
        vp.setAdapter(pagerAdapter);

        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.page_1);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.page_2);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.page_3);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.page_4);
                        break;
                }
            }
        });

        // configure bottom navigation bar
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            String page = item.getTitle().toString();
            switch (page) {
                case "Home":
                    vp.setCurrentItem(0, true);
                    break;
                case "Bookmark":
                    vp.setCurrentItem(1, true);
                    break;
                case "Clubs":
                    vp.setCurrentItem(2, true);
                    break;
                case "Profile":
                    vp.setCurrentItem(3, true);
                    break;
            }
            return true;
        });


    }
}