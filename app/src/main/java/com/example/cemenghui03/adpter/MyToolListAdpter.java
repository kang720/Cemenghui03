package com.example.cemenghui03.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.entity.Item3;

import java.util.List;

public class MyToolListAdpter extends BaseAdapter {
    private List<Item3> item3List;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyToolListAdpter(Context context, List<Item3> item3List) {
        this.context = context;
        this.item3List = item3List;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return item3List.size();
    }

    @Override
    public Object getItem(int position) {
        return item3List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.tool_item,parent,false);
        Item3 item3= item3List.get(position);
        ImageView imageView=convertView.findViewById(R.id.tool_img);
        TextView textView=convertView.findViewById(R.id.tool_content);
        TextView textView1=convertView.findViewById(R.id.tool_company);
        imageView.setImageResource(item3.getImg());
        textView.setText(item3.getContent());
        textView1.setText(item3.getCompany());
        return convertView;
    }
}
