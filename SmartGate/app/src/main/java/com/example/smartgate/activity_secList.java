package com.example.smartgate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.smartgate.R;
import com.example.smartgate.Securities;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

    public class activity_secList extends AppCompatActivity {
    private HashMap<String, Securities> hashMap = new HashMap<String, Securities>();
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> pos = new ArrayList<>();

    ListView listView;
    Button addForm;
    ImageButton add;
    LinearLayout BottomSheetForm;
    private BottomSheetBehavior bottomSheetBehavior;
    private androidx.appcompat.widget.Toolbar toolbar;
    private UserAdapter userAdapter;

    @SuppressLint({"NewApi", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_list);

        addForm = (Button) findViewById(R.id.add_Form);
        add = (ImageButton) findViewById(R.id.list_imgbtn_add_person);
        listView = (ListView) findViewById(R.id.listView);
        toolbar = (Toolbar) findViewById(R.id.toolbarl1);
        BottomSheetForm = (LinearLayout) findViewById(R.id.list_add_form);

        AddSecurityFromFileCVS();
        initToolbar();
        Print(toString());

        bottomSheetBehavior = BottomSheetBehavior.from(BottomSheetForm);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        listView.setOnTouchListener(new TranslateAnimationUtil(this, add));

        addForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,pos);
        //Thiết lập cách hiển thị dữ liệu trong spinner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

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

    public void AddSecurityFromFileCVS() {
        try {
            String splitBy = ",";
            FileInputStream in = this.openFileInput("Data.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //Lưu chuỗi "All" vào đầu danh sách ngành
//            pos.add("All");
            while(br != null) {
                String line = br.readLine();
                String[] value = line.split(splitBy);
                //Lưu tất cả danh sách SV vào Hashmap
                hashMap.put(value[0],new Securities(value[0], value[1], value[2]));

                //Kiểm tra nếu chưa có tên ngành trong danh sách thì thêm vào major list
                if(!pos.contains(value[2])){
                    pos.add(value[2]);
                }
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void Print(String s) {
        list.clear(); //Mỗi lần hiển thị mới phải xóa list trước

            for (Securities x: hashMap.values()) {
                list.add(x.toString());
            }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter1);
        }
}