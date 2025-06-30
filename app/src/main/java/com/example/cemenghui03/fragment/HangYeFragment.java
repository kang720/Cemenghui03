package com.example.cemenghui03.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cemenghui03.DongTaiDetail;
import com.example.cemenghui03.R;
import com.example.cemenghui03.adpter.MyDongTaiAdapter;
import com.example.cemenghui03.entity.Item4;
import com.example.cemenghui03.helper.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HangYeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HangYeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView list;
    private EditText editText;
    private List<Item4> item4List;
    private MySqlHelper mySqlHelper;
    private MyDongTaiAdapter myDongTaiAdapter;

    public HangYeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HangYeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HangYeFragment newInstance(String param1, String param2) {
        HangYeFragment fragment = new HangYeFragment();
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
        return inflater.inflate(R.layout.fragment_hang_ye, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mySqlHelper = new MySqlHelper(getContext());
        swipeRefreshLayout = view.findViewById(R.id.fresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        });
        editText = view.findViewById(R.id.dongtai_search);
        list = view.findViewById(R.id.dongtai_list);



        item4List = mySqlHelper.selectAllData();
        myDongTaiAdapter = new MyDongTaiAdapter(item4List, getContext());
        list.setAdapter(myDongTaiAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Item4 item4 = item4List.get(position);
                bundle.putInt("img", item4.getImg());
                bundle.putString("name", item4.getName());
                bundle.putString("introduction", item4.getIntroduction());
                bundle.putString("content", item4.getContent());
                bundle.putString("date", item4.getDate());
                Intent intent = new Intent(getContext(), DongTaiDetail.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input=s.toString();
                item4List.clear();
                List<Item4> reitem4List;
                try {
                    if (input=="") {
                        reitem4List = mySqlHelper.selectAllData();
                    } else {
                        reitem4List = mySqlHelper.selectByKey(input);
                        Log.d("output",""+item4List.size());
                    }
                    for(Item4 item4:reitem4List){
                        item4List.add(item4);
                    }
                } catch (Exception e) {
                    Log.e("TAG", "执行数据库查询/刷新适配器失败", e);
                    // 打印异常，就能发现问题
                }
                myDongTaiAdapter.freshUI();

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}