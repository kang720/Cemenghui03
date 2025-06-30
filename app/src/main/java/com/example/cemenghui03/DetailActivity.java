package com.example.cemenghui03;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView name;
    private TextView company;
    private TextView desc;
    private TextView data;
    private TextView position;
    private TextView company1;
    private TextView process;
    private TextView attendence;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        Bundle bundle=getIntent().getExtras();
        imageView=findViewById(R.id.detail_img);
        name=findViewById(R.id.detail_name);
        company=findViewById(R.id.detail_company);
        desc=findViewById(R.id.detail_desc);
        data=findViewById(R.id.detail_data);
        position=findViewById(R.id.detail_position);
        company1=findViewById(R.id.detail_company1);
        process=findViewById(R.id.detail_process);
        attendence=findViewById(R.id.detail_attendence);
        button=findViewById(R.id.detail_back);

        imageView.setImageResource(bundle.getInt("img"));
        name.setText(bundle.getString("name"));
        company.setText(bundle.getString("company"));
        desc.setText(bundle.getString("desc"));
        data.setText(bundle.getString("data"));
        position.setText(bundle.getString("location"));
        company1.setText(bundle.getString("company"));
        process.setText(bundle.getString("process"));
        attendence.setText(bundle.getString("attendence"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,HuiZhiActivity.class);
                startActivity(intent);
            }
        });
    }
}