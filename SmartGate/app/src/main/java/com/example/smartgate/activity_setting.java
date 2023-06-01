package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.Locale;

public class activity_setting extends Fragment {

    private TextView txttitle, txtlanguge;
    private ImageButton imgbtnlanguage;
    private RadioGroup rdbglanguge;
    private RadioButton rdbVi, rdbEn;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private LinearLayout layoutBottomsheet;
    private BottomSheetBehavior bottomSheetBehavior;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_setting, container,false);

        imgbtnlanguage = (ImageButton) view.findViewById(R.id.setting_imgbtn_ngongu);
        rdbglanguge = (RadioGroup) view.findViewById(R.id.setting_rdbg_ngonngu);
        txtlanguge = (TextView) view.findViewById(R.id.setting_txt_ngongnu1);
        txttitle = (TextView) view.findViewById(R.id.setting_txt_ngonngu);
        rdbVi = (RadioButton) view.findViewById(R.id.setting_gdb_tiengviet);
        rdbEn = (RadioButton) view.findViewById(R.id.setting_gdb_tienganh);
        layoutBottomsheet = (LinearLayout) view.findViewById(R.id.setting_bottomsheet_ngonngu);

        bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomsheet);

        sharedPreferences = getActivity().getSharedPreferences("pref",0);
        int langugeSP = sharedPreferences.getInt("langugeSP",3);
        editor = sharedPreferences.edit();
        if (langugeSP == 1) {
            rdbEn.setChecked(true);
//            setLocale("en");
        } else if (langugeSP == 0) {
            rdbVi.setChecked(true);
//            setLocale("vi");
        }

        imgbtnlanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    rdbglanguge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            if(i == R.id.setting_gdb_tienganh) {
                                editor.putInt("langugeSP",1);
//                                String languge = "en";
                                setLocale("en");
                            } else if (i == R.id.setting_gdb_tiengviet) {
                                editor.putInt("langugeSP",0);
                                setLocale("vi");
                            }
                            editor.commit();

                            switch (i){
                                case R.id.setting_gdb_tienganh:
                                    String languge = "en";
                                    setLocale(languge);
                                    break;
                                case R.id.setting_gdb_tiengviet:
                                    setLocale("vi");
                                    break;
                            }
                        }
                    });
                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        return view;
    }
//
//    public void btnChecked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//    }

    private void setLocale(String languge) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(languge);
        resources.updateConfiguration(configuration, metrics);
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        txttitle.setText(R.string.languge);
        txtlanguge.setText(R.string.languge);
        rdbEn.setText(R.string.english);
        rdbVi.setText(R.string.vietnamese);
    }
}
