package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_forgotpassword extends AppCompatActivity {

    Button btnnet;
    TextView txtsignin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forgotpassword);

        btnnet = (Button) findViewById(R.id.forgot_btn_login);
        txtsignin = (TextView) findViewById(R.id.forgot_txt_SignIn);

        btnnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_forgotpassword.this,activity_forgorpassword_getnewpass.class);
                startActivity(intent);
            }
        });
    }
}
