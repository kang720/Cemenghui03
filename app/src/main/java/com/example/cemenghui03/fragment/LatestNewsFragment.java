package com.example.cemenghui03.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.MyFragmentStateVPTLAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LatestNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LatestNewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragmentList;
    private MyFragmentStateVPTLAdapter fragmentStateVPTLAdapter;
    private List<String> titleList;

    public LatestNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LatestNewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LatestNewsFragment newInstance(String param1, String param2) {
        LatestNewsFragment fragment = new LatestNewsFragment();
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
        return inflater.inflate(R.layout.fragment_latest_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.lastest_news_vp);
        initData();
        fragmentStateVPTLAdapter = new MyFragmentStateVPTLAdapter(getChildFragmentManager(), fragmentList,titleList);
        viewPager.setAdapter(fragmentStateVPTLAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        StandardMakeFragment standardMakeFragment = new StandardMakeFragment();
        SkillFragment skillFragment = new SkillFragment();
        ToolFragment toolFragment = new ToolFragment();
        GongYiFragment gongYiFragment = new GongYiFragment();

        fragmentList.add(standardMakeFragment);
        fragmentList.add(skillFragment);
        fragmentList.add(toolFragment);
        fragmentList.add(gongYiFragment);

        titleList = new ArrayList<>();
        titleList.add("标准定制");
        titleList.add("技术培训");
        titleList.add("工具研发");
        titleList.add("公益行动");

    }

}