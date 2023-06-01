package com.example.smartgate;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.smartgate.R;

import java.util.ArrayList;

public class activity_history extends AppCompatActivity {

    ListView listView;
    private androidx.appcompat.widget.Toolbar toolbar;

//    private ArrayList<String> list = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_history);

        toolbar = (Toolbar) findViewById(R.id.toolbarl_history);
        listView = (ListView) findViewById(R.id.listview_history);

        initToolbar();

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
