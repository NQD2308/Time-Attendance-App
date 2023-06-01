package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity_Home extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    ImageButton secList;
    ImageButton listIdCard;
    ImageButton history;
    ImageButton statistic;

    private long backPressTime;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home, container, false);

        secList = (ImageButton) view.findViewById(R.id.imgbtn_listsec);
        secList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), activity_secList.class);
                startActivity(intent);
            }
        });

        history = (ImageButton) view.findViewById(R.id.home_imgbtn_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_history.class);
                startActivity(intent);
            }
        });

        listIdCard = (ImageButton) view.findViewById(R.id.home_imgbtn_createID);
        listIdCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_Idcard.class);
                startActivity(intent);
            }
        });

        statistic = (ImageButton) view.findViewById(R.id.home_imgbtn_statistics);
        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_statistics.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
