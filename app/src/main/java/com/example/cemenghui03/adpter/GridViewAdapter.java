package com.example.cemenghui03.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.entity.Item2;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Item2> item2List;
    private LayoutInflater layoutInflater;

    public GridViewAdapter(Context context, List<Item2> item2List) {
        this.context = context;
        this.item2List = item2List;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return item2List.size();
    }

    @Override
    public Object getItem(int position) {
        return item2List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.skill_item,parent,false);
        ImageView img=convertView.findViewById(R.id.sk_img);
        TextView time=convertView.findViewById(R.id.sk_time);
        TextView title=convertView.findViewById(R.id.sk_title);
        TextView author=convertView.findViewById(R.id.sk_author);

        Item2 item2=item2List.get(position);
        img.setImageResource(item2.getImg());
        time.setText(item2.getTime());
        title.setText(item2.getTitle());
        author.setText(item2.getAuthor());


        return convertView;
    }
}
