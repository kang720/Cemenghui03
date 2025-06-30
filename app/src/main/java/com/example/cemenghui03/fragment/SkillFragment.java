package com.example.cemenghui03.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.GridViewAdapter;
import com.example.cemenghui03.entity.Item1;
import com.example.cemenghui03.entity.Item2;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GridView gridView;
    private List<Item2> item2List;
    private GridViewAdapter gridViewAdapter;

    public SkillFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillFragment newInstance(String param1, String param2) {
        SkillFragment fragment = new SkillFragment();
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
        return inflater.inflate(R.layout.fragment_skill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        gridView=view.findViewById(R.id.grid_skill);
        initdata();
        gridViewAdapter=new GridViewAdapter(getContext(),item2List);
        gridView.setAdapter(gridViewAdapter);
    }

    private void initdata() {
        item2List=new ArrayList<>();
        item2List.add(new Item2(R.drawable.a1,"30:23","高效沟通技巧","张三"));
        item2List.add(new Item2(R.drawable.a2,"50:23","数字化转型","赵六"));
        item2List.add(new Item2(R.drawable.a3,"12:32","时间管理秘籍","王五"));
        item2List.add(new Item2(R.drawable.a4,"67:16","团队协作与创新","李四"));
        item2List.add(new Item2(R.drawable.a5,"24:23","传统文化传承","孙七"));
        item2List.add(new Item2(R.drawable.a6,"64:23","新媒体营销策略","周八"));
        item2List.add(new Item2(R.drawable.a7,"32:15","创意手工制作","郑十"));
    }
}