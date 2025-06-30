package com.example.cemenghui03;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cemenghui03.fragment.HangYeFragment;
import com.example.cemenghui03.fragment.MeetingFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle mToggle;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navi_draw);
        toolbar=findViewById(R.id.mybar);
        setSupportActionBar(toolbar);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        setMeetingPage();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_meeting:
                        MeetingFragment meetingFragment=new MeetingFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fcv,meetingFragment)
                                .commit();
                        break;
                    case R.id.menu_hangye:
                        HangYeFragment hangYeFragment=new HangYeFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fcv,hangYeFragment)
                                .commit();
                }
                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });

    }
    private void setMeetingPage(){
        MeetingFragment meetingFragment=new MeetingFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fcv,meetingFragment)
                .commit();
        navigationView.setCheckedItem(R.id.menu_meeting);

    }

}