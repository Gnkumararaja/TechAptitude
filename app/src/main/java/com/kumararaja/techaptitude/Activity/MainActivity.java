package com.kumararaja.techaptitude.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kumararaja.techaptitude.R;
import com.kumararaja.techaptitude.Utilities.RoundedImage;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private static final int REQUEST_CODE = 1;

    private static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};


    TextInputLayout username, password;
    Button login;
    TextView forget;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        init();
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Aptitude");

      Bitmap a= BitmapFactory.decodeResource(this.getResources(),R.drawable.apple);
        image.setImageBitmap(new RoundedImage(MainActivity.this).transform(a));


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (username.getText().toString().trim().equalsIgnoreCase("")) {
                    username.setError("Error");
                } else {
                    if (password.getText().toString().trim().equalsIgnoreCase("")) {
                        password.setError("Error");
                    } else {

                    }
                }*/

                Intent i = new Intent(MainActivity.this, Homepage.class);
                startActivity(i);

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
        image=findViewById(R.id.login_image);
        verifyPermissions();
    }

    private void verifyPermissions(){
        Log.v("VerifyPermission","Checking Permission");

       /* if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[0])== PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[1])== PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[2])== PackageManager.PERMISSION_GRANTED){

        } else {
            ActivityCompat.requestPermissions(MainActivity.this,PERMISSIONS,REQUEST_CODE);
        }*/
        int permissionReadEx = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        int permissionWriteEx = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (permissionReadEx!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS,REQUEST_CODE
            );
        }

        if (permissionWriteEx!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS,REQUEST_CODE
            );
        }
    }

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }*/
}
