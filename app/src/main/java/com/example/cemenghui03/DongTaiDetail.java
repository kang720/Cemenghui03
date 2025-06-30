package com.example.cemenghui03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DongTaiDetail extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView introduction;
    private TextView content;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_dong_tai_detail);
        Bundle bundle = getIntent().getExtras();
        img = findViewById(R.id.dongtai_detail_img);
        name = findViewById(R.id.dongtai_detail_name);
        introduction = findViewById(R.id.dongtai_detail_introduction);
        content = findViewById(R.id.dongtai_detail_content);
        date = findViewById(R.id.dongtai_detail_date);
        img.setImageResource(bundle.getInt("img"));
        name.setText(bundle.getString("name"));
        introduction.setText(bundle.getString("introduction"));
        content.setText(bundle.getString("content"));
        date.setText(bundle.getString("date"));


    }
}