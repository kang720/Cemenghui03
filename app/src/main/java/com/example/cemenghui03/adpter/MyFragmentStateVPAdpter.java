package com.example.cemenghui03.adpter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyFragmentStateVPAdpter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public MyFragmentStateVPAdpter(@NonNull FragmentManager fm, List<Fragment> fragmentList ) {
        super(fm);
        this.fragmentList=fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
