package com.example.cemenghui03.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.entity.Item4;

import java.util.List;

public class MyDongTaiAdapter extends BaseAdapter {
    private List<Item4> item4List;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyDongTaiAdapter(List<Item4> item4List, Context context) {
        this.item4List = item4List;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return item4List.size();
    }

    @Override
    public Object getItem(int position) {
        return item4List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.dongtai_item,parent,false);
        Item4 item4 = item4List.get(position);
        ImageView img = convertView.findViewById(R.id.dongtai_img);
        TextView name = convertView.findViewById(R.id.dongtai_name);
        img.setImageResource(item4.getImg());
        name.setText(item4.getName());
        return convertView;
    }

    public void freshUI() {
        notifyDataSetChanged();
    }
}
