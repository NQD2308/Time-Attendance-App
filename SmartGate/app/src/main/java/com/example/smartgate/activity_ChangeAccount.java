package com.example.smartgate;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class activity_ChangeAccount extends Fragment {

    Button reset;
    EditText edtchangepass, edtconfirmpass;
    boolean passwordVisible;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_changepassword_setnewpass, container, false);

        reset = (Button) view.findViewById(R.id.changepassword_btn_resetnewpass);
        edtchangepass = (EditText) view.findViewById(R.id.changepassword_edittxt_password);
        edtconfirmpass = (EditText) view.findViewById(R.id.changepassword_edittxt_confirmpass);

        edtchangepass.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right =2;
                if(motionEvent.getAction() == motionEvent.ACTION_UP);{
                    if(motionEvent.getRawX() >= edtchangepass.getRight()-edtchangepass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = edtchangepass.getSelectionEnd();
                        if(passwordVisible){
                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,R.drawable.ic_light_off,0);
                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,0,0);
                            edtchangepass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            edtconfirmpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        } else {
                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,R.drawable.ic_light,0);
                            edtconfirmpass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,0,0);
                            edtchangepass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtconfirmpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        edtchangepass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });
        return view;
    }


//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_changepassword_setnewpass);
//
//        reset = (Button) findViewById(R.id.changepassword_btn_resetnewpass);
//        edtchangepass = (EditText) findViewById(R.id.changepassword_edittxt_password);
//        edtconfirmpass = (EditText) findViewById(R.id.changepassword_edittxt_confirmpass);

//        edtchangepass.setOnTouchListener(new View.OnTouchListener() {
//            @SuppressLint("ClickableViewAccessibility")
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                final int Right =2;
//                if(motionEvent.getAction() == motionEvent.ACTION_UP);{
//                    if(motionEvent.getRawX() >= edtchangepass.getRight()-edtchangepass.getCompoundDrawables()[Right].getBounds().width()){
//                        int selection = edtchangepass.getSelectionEnd();
//                        if(passwordVisible){
//                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,R.drawable.ic_light_off,0);
//                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,0,0);
//                            edtchangepass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                            edtconfirmpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                            passwordVisible = false;
//                        } else {
//                            edtchangepass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,R.drawable.ic_light,0);
//                            edtconfirmpass.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_changelock,0,0,0);
//                            edtchangepass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                            edtconfirmpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                            passwordVisible = true;
//                        }
//                        edtchangepass.setSelection(selection);
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

//        reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //
//            }
//        });
//    }
}
