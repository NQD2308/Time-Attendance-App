package com.example.smartgate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.bson.Document;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class activity_login extends AppCompatActivity {

    EditText edtUser, edtPassword;
    boolean passwordVíible;
    Button btnlogin;
    TextView txterrorlogin;
    TextView txtforgetpass;
    CheckBox ckbremember;
    String Appid = "application-0-pmutg";
    MongoDatabase mongoDatabase;
    MongoClient mongoClient;

        @SuppressLint("MissingInflatedId")
        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

            edtUser = (EditText) findViewById(R.id.login_edittxt_username);
            edtPassword = (EditText) findViewById(R.id.login_edittxt_password);
            btnlogin = (Button) findViewById(R.id.login_btn_login);
            txterrorlogin = (TextView) findViewById(R.id.txt_loidangnhap) ;
            txtforgetpass = (TextView) findViewById(R.id.login_txt_forgetpasswod);
            ckbremember = (CheckBox) findViewById(R.id.ckb_rememberme);

            edtPassword.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    final int Right =2;
                    if(motionEvent.getAction() == motionEvent.ACTION_UP);{
                        if(motionEvent.getRawX() >= edtPassword.getRight()-edtPassword.getCompoundDrawables()[Right].getBounds().width()){
                            int selection = edtPassword.getSelectionEnd();
                            if(passwordVíible){
                                edtPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_lock,0,R.drawable.ic_light_off,0);
                                edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                passwordVíible = false;
                            } else {
                                edtPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_lock,0,R.drawable.ic_light,0);
                                edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                passwordVíible = true;
                            }
                            edtPassword.setSelection(selection);
                            return true;
                        }
                    }
                    return false;
                }
            });

            txtforgetpass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity_login.this,activity_forgotpassword.class);
                    startActivity(intent);
                }
            });

            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity_login.this, Activity_Navigation.class);
                    startActivity(intent);
                }
            });

//            Log.v("User","hello");
//            btnlogin.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                        Intent intent = new Intent(activity_login.this,Activity_Navigation.class);
//                        startActivity(intent);
//                }
//            });

//            String Appid = "application-0-pmutg";
//            String Appid = "smartgate-efdoc";
//            Realm.init(this);
//            App app = new App(new AppConfiguration.Builder(Appid).build());
//            Credentials credentials = Credentials.emailPassword("taduc1130@gmail.com","hahahaha1X");
//
//            app.loginAsync(credentials, new App.Callback<User>() {
//                @Override
//
//                public void onResult(App.Result<User> result) {
//                    if(result.isSuccess())
//                    {
//
//                        Toast.makeText(getApplicationContext(),"Thành công",Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(getApplicationContext(),"Thất bại",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });






//            Realm.init(this);
//            Log.v("User","hello");
//
//            App app = new App(new AppConfiguration.Builder(Appid).build());
//
//
//            Credentials credentials = Credentials.emailPassword("tr6r20@gmail.com","1234567");
//            Log.e("Check","hehe");

          /*  app.loginAsync(credentials, new App.Callback<User>() {
                @Override
                public void onResult(App.Result<User> result) {
                    if (result.isSuccess())
                    {
                        Log.d("check", "thanh cong ");
                    }
                    else
                    {
                        Log.d("check", "that bại");
                    }
                }
            });*/

//            User user = app.currentUser();
//            mongoClient = user.getMongoClient("mongodb-atlas");
//            mongoDatabase = mongoClient.getDatabase("Gate");
//            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");
//       btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Document queryFilter = new Document().append("user",edtUser.getText().toString());
//
//                mongoCollection.findOne(queryFilter).getAsync(kq1 -> {
//                    if(kq1.isSuccess()){
//                        Document document = kq1.get();
//                        if(document == null) {
//                            edtUser.setTextColor(Color.RED);
//                           txterrorlogin.setTextColor(Color.RED);
//                            txterrorlogin.setText("**Sai Tài Khoản");
//                        } else {
//                            if(document.getString("user").equals(edtUser.getText().toString())) {
//                                edtUser.setTextColor(Color.BLACK);
//                                txterrorlogin.setText("");
//                                Document queryFilter2 = new Document("user",edtUser.getText().toString())
//                                        .append("password",edtPassword.getText().toString());
//                                mongoCollection.findOne(queryFilter2).getAsync(kq2 -> {
//                                    if(kq2.isSuccess()) {
//                                        Document document1 = kq2.get();
//                                        if (document1 == null) {
//                                            edtPassword.setTextColor(Color.RED);
//                                            txterrorlogin.setTextColor(Color.RED);
//                                            txterrorlogin.setText("**Sai Mật khẩu");
//                                        } else {
//                                            if (document1.getString("password").equals(edtPassword.toString())) {
//                                                edtPassword.setTextColor(Color.BLACK);
//                                                txterrorlogin.setText("");
//                                                Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công",
//                                                        Toast.LENGTH_SHORT).show();
//
//                                                Intent intent = new Intent(activity_login.this, Activity_Navigation.class);
//                                                startActivity(intent);
//                                            }
//                                        }
//                                    }
//                                });
//                            }
//                        }
//                    }
//                });
//            }
//        });
    }
}
