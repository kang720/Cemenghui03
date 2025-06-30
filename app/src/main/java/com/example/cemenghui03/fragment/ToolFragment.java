package com.example.cemenghui03.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.MyToolListAdpter;
import com.example.cemenghui03.entity.Item1;
import com.example.cemenghui03.entity.Item3;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ListView listView;
    private List<Item3> item3List;
    private MyToolListAdpter toolListAdpter;

    public ToolFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolFragment newInstance(String param1, String param2) {
        ToolFragment fragment = new ToolFragment();
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
        return inflater.inflate(R.layout.fragment_tool, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView=view.findViewById(R.id.tool_list);
        initData();
        toolListAdpter=new MyToolListAdpter(getContext(),item3List);
        listView.setAdapter(toolListAdpter);

    }

    private void initData() {
        item3List=new ArrayList<>();
        item3List.add(new Item3(R.drawable.b1,"Leming WebRunner","迎风聚智"));
        item3List.add(new Item3(R.drawable.b2,"LEming TPC-E2.0","迎风聚智"));
        item3List.add(new Item3(R.drawable.b3,"龙测AI-TestOps云平台","苏州市龙测智能科技有限公司"));
        item3List.add(new Item3(R.drawable.b4,"软件造价评估系统","东北大学 郭军"));
        item3List.add(new Item3(R.drawable.b5,"信息安全风评系统","沈阳织知科技有限公司 武旭春"));

    }

}