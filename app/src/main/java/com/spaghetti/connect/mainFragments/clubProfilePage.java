package com.spaghetti.connect.mainFragments;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.spaghetti.connect.R;

public class clubProfilePage extends Fragment{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TabSwitchAdapter tabSwitchAdapter;
    ViewPager2 viewPager;

    private Context context;

    public clubProfilePage(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragement_clubprofilepage, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String[] titles = new String[]{"Details", "Events"};
        tabSwitchAdapter = new TabSwitchAdapter(this);
        viewPager = view.findViewById(R.id.profile_club_pager);
        viewPager.setAdapter(tabSwitchAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabMode);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(titles[position])
        ).attach();

    }


    public static class TabSwitchAdapter extends FragmentStateAdapter {

        public TabSwitchAdapter(Fragment fragment) {
            super(fragment);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Return a NEW fragment instance in createFragment(int)
            Fragment fragment = new ClubDetailsFragment();
            Bundle args = new Bundle();
            // Our object is just an integer :-P
            args.putString(ClubDetailsFragment.ARG_EM, "123@email.com");
            args.putString(ClubDetailsFragment.ARG_DS, "123456");
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public static class ClubDetailsFragment extends Fragment {

        public static final String ARG_EM = "em";
        public static final String ARG_DS = "ds";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(R.layout.club_cardview, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            Bundle args = getArguments();
            TextView clubEmail = (TextView) view.findViewById(R.id.profile_club_email);
            TextView clubDes = (TextView) view.findViewById(R.id.profile_club_description);
            clubEmail.setText(args.getString(ARG_EM));
            Log.d("tag","print:" + args.getString(ARG_EM));
            clubDes.setText(args.getString(ARG_DS));
        }

//    public static ClubDetailsFragment newInstance(String email, String des) {
//
//        ClubDetailsFragment  f = new ClubDetailsFragment();
//        Bundle b = new Bundle();
//        b.putString("em", email);
//        b.putString("ds", des);
//        f.setArguments(b);
//        return f;
//    }
    }

}
