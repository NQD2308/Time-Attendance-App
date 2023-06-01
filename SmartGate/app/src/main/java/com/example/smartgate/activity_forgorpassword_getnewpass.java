package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_forgorpassword_getnewpass extends AppCompatActivity {

    Button btn_resetpassword;
    TextView txt_signIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forgotpassword_setnewpass);

        btn_resetpassword = (Button) findViewById(R.id.forgot_btn_resetnewpass);
        txt_signIn = (TextView) findViewById(R.id.forgot_txt_SignIn);

        txt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_forgorpassword_getnewpass.this,activity_login.class);
                startActivity(intent);
            }
        });
    }
}
