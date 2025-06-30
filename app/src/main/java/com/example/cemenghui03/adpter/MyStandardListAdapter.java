package com.example.cemenghui03.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.entity.Item1;

import java.util.List;

public class MyStandardListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Item1> item1List;
    public MyStandardListAdapter(Context context,List<Item1> item1List){
        this.context=context;
        this.item1List=item1List;
        this.layoutInflater=LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return item1List.size();
    }

    @Override
    public Object getItem(int position) {
        return item1List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.standard_make_item,parent,false);
        TextView title=convertView.findViewById(R.id.title);
        TextView date=convertView.findViewById(R.id.date);
        Item1 item1=item1List.get(position);
        title.setText(item1.getTitle());
        date.setText(item1.getDate());
        return convertView;
    }
}
