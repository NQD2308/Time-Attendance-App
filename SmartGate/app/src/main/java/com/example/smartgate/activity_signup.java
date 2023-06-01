package com.example.smartgate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoDatabase;

public class activity_signup extends AppCompatActivity {

    Button btnsignUp;
    EditText edtUser, edtEmail, edtPassword, edtConfirm;

    boolean isEnable1 = false;
    boolean isEnable2 = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        edtUser = (EditText) findViewById(R.id.signup_edittxt_username);
        edtEmail = (EditText) findViewById(R.id.signup_edittxt_Email);
        edtPassword = (EditText) findViewById(R.id.signup_edittxt_password) ;
        edtConfirm = (EditText) findViewById(R.id.esignup_edittxt_confirmpassword);
        btnsignUp = (Button) findViewById(R.id.signup_btn_signout);

        String Appid = "application-0-pmutg";
        Realm.init(this);
        MongoDatabase mongoDatabase;
        MongoClient mongoClient;

        btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
