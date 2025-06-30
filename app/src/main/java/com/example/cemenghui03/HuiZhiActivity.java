package com.example.cemenghui03;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class HuiZhiActivity extends AppCompatActivity {
    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hui_zhi);
        spinner=findViewById(R.id.arrival_method);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.arrive, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        button=findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HuiZhiActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}