package com.example.cemenghui03.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cemenghui03.R;
import com.example.cemenghui03.entity.MeetingBean;

import java.util.List;

public class MeetingItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<MeetingBean> meetingBeanList;

    public MeetingItemAdapter(List<MeetingBean> meetingBeanList, Context context) {
        this.meetingBeanList = meetingBeanList;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return meetingBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return meetingBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.meeting_item,parent,false);
        ImageView imageView=convertView.findViewById(R.id.meeting_img);
        TextView textView=convertView.findViewById(R.id.meeting_name);
        TextView textView1=convertView.findViewById(R.id.meeting_company);
        MeetingBean meetingBean=meetingBeanList.get(position);
        imageView.setImageResource(meetingBean.getImg());
        textView.setText(meetingBean.getName());
        textView1.setText(meetingBean.getCompany());
        return convertView;
    }
}
