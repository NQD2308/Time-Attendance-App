package com.example.smartgate;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class activity_Idcard extends AppCompatActivity {

    ListView listView;
    ImageButton addform, update, lock;
    Button add, search,save,locked;
    LinearLayout BottomSheetForm_add;
    LinearLayout BottomSheetForm_update;

    RelativeLayout relativeLayout;
    private BottomSheetBehavior bottomSheetBehavior_add;
    private BottomSheetBehavior bottomSheetBehavior_update;
    private androidx.appcompat.widget.Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_card);

        add = (Button) findViewById(R.id.add_idcardForm);
        search = (Button) findViewById(R.id.listidcard_imgbtn_search);

        addform = (ImageButton) findViewById(R.id.listidcard_imgbtn_addidcard);
        update = (ImageButton) findViewById(R.id.listidcard_imgbtn_update);
        lock = (ImageButton) findViewById(R.id.listidcard_imgbtn_lock);

        toolbar = (Toolbar) findViewById(R.id.toolbarl_idcard);
        listView = (ListView) findViewById(R.id.listidcard_listView_idcard);

        BottomSheetForm_add = (LinearLayout) findViewById(R.id.listidcard);
        BottomSheetForm_update = (LinearLayout) findViewById(R.id.listidcard_update);
        relativeLayout = (RelativeLayout) findViewById(R.id.Relative_functions_listidcard);

        save = (Button) findViewById(R.id.update_idcardForm_save);
        locked = (Button) findViewById(R.id.update_idcardForm_locked);

        initToolbar();

        bottomSheetBehavior_add = BottomSheetBehavior.from(BottomSheetForm_add);
        addform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior_add.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior_add.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior_add.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bottomSheetBehavior_add.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior_add.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        bottomSheetBehavior_update = BottomSheetBehavior.from(BottomSheetForm_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior_update.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior_update.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior_update.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bottomSheetBehavior_update.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior_update.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_Lock(Gravity.CENTER);
            }
        });

        listView.setOnTouchListener(new TranslateAnimationUtil(this, relativeLayout));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void Dialog_Lock(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_delete);

        Window window = dialog.getWindow();
        if(window == null)
        {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == gravity) {
            dialog.setCancelable(true);
        }

        Button cancel = dialog.findViewById(R.id.confirmlock_btn_cancel);
        Button locked = dialog.findViewById(R.id.confirmlock_btn_lock);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        locked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_Idcard.this, "This ID is Locked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
