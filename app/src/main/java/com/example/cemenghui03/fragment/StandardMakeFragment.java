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
import com.example.cemenghui03.adpter.MyStandardListAdapter;
import com.example.cemenghui03.entity.Item1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandardMakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandardMakeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Item1> item1List;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StandardMakeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandardMakeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandardMakeFragment newInstance(String param1, String param2) {
        StandardMakeFragment fragment = new StandardMakeFragment();
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
        return inflater.inflate(R.layout.fragment_standard_make, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView=view.findViewById(R.id.standard_list);
        initData();
        MyStandardListAdapter myStandardListAdapter=new MyStandardListAdapter(getContext(),item1List);
        listView.setAdapter(myStandardListAdapter);
    }

    private void initData() {
        item1List=new ArrayList<>();
        item1List.add(new Item1("关于批准《民用钠电池电动自行车换电设施总体技术要求》等两项团体标准立项的函","2025-05-22"));
        item1List.add(new Item1("团体标准《民用钠电池电动自行车换电设施总体技术要求》等两项标准立项公示","2025-05-22"));
        item1List.add(new Item1("关于批准《工业操作系统 协议通用要求》 等两项团体标准立项的函","2025-05-22"));
        item1List.add(new Item1("团体标准《工业操作系统 协议通用要求》等两项标准立项公示","2025-05-06"));
        item1List.add(new Item1("关于批准《铝电解电容器失效分析方法与程序》等三项团体标准立项的函","2025-05-06"));
        item1List.add(new Item1("团体标准《铝电解电容器失效分析方法与程序》等三项标准立项公示","2025-05-22"));
        item1List.add(new Item1("关于批准《人工智能数据集 质量评价指标体系》等六项团体标准立项的函","2025-04-09"));
        item1List.add(new Item1("团体标准《人工智能数据集 质量评价指标体系》等六项标准立项公示","2025-04-09"));
        item1List.add(new Item1(" 团体标准《固态锂电池通用技术规范》等四项标准 立项公示","2025-04-09"));

    }
}