package com.example.cemenghui03.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.MyFragmentStateVPAdpter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeetingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetingFragment extends Fragment {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MyFragmentStateVPAdpter myFragmentStateVPAdpter;
    private List<Fragment> fragmentList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MeetingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeetingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeetingFragment newInstance(String param1, String param2) {
        MeetingFragment fragment = new MeetingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_meeting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=view.findViewById(R.id.vp);
        bottomNavigationView=view.findViewById(R.id.bottom_view);
        initData();
        myFragmentStateVPAdpter=new MyFragmentStateVPAdpter(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentStateVPAdpter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onPagerSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.lastest_news:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.my_meeting:
                        viewPager.setCurrentItem(1);
                        break;
                }

                return true;
            }
        });
    }

    private void onPagerSelected(int position) {
        switch (position){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.lastest_news);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.my_meeting);
                break;

        }
    }

    private void initData(){
        fragmentList=new ArrayList<>();
        fragmentList.add(new LatestNewsFragment());
        fragmentList.add(new MyMeetingFragment());
    }
}