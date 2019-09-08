package com.kumararaja.techaptitude.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kumararaja.techaptitude.R;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Aptitude");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().equalsIgnoreCase("")) {
                    username.setError("Error");
                } else {
                    if (password.getText().toString().trim().equalsIgnoreCase("")) {
                        password.setError("Error");
                    } else {
                        Intent i = new Intent(MainActivity.this, Homepage.class);
                        startActivity(i);
                    }
                }

            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(i);
            }
        });


    }

    private void init() {
        username = findViewById(R.id.uname);
        password = findViewById(R.id.password);
        forget = findViewById(R.id.t_forget_password);
        login = findViewById(R.id.btn_login);
    }
}
