package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class activity_welcome extends AppCompatActivity {

    Button btnsignUp;
    Button btnlogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);

        btnlogin = (Button) findViewById(R.id.welcome_btn_login);
        btnsignUp = (Button) findViewById(R.id.welcome_btn_signUp);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == btnlogin){

                    Intent intent = new Intent(view.getContext(), activity_login.class);
                    startActivity(intent);
                }
            }
        });

        btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_signup.class);
                startActivity(intent);
            }
        });
    }
}
