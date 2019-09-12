package com.kumararaja.techaptitude.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kumararaja.techaptitude.R;
import com.kumararaja.techaptitude.Utilities.RoundedImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    Spinner spinner,spinner1;
    TextView signout,pg,ug,ssc;
    ImageView education,place,profilepic;
    private int GALLERY = 1, CAMERA = 2;
    private static final int REQUEST_CODE = 1;

    private static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        signout=findViewById(R.id.signout);
        spinner=findViewById(R.id.txtstate);
        spinner1=findViewById(R.id.txtcity);
        pg=findViewById(R.id.txtpg);
        ug=findViewById(R.id.txtUg);
        ssc=findViewById(R.id.txtssc);
        education=findViewById(R.id.education_edit);
        place=findViewById(R.id.place_edit);
        profilepic=findViewById(R.id.profile_pic);

        List<String> list=new ArrayList<String>();
        list.add("Andhra Pradesh");
        list.add("Tamilnadu");
        list.add("Telungana");
        list.add("Karnataka");

        List<String> listc=new ArrayList<String>();
        listc.add("Madiwala");
        listc.add("Jainagar");
        listc.add("Majestic");
        listc.add("siklboard");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapterr = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,listc);
        adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapterr);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyPermissions();
                AlertDialog.Builder pictureDialog=new AlertDialog.Builder(ProfileActivity.this);
                pictureDialog.setTitle("Select Action");
                String[] pictureDialogItems={
                        "Gallery","Camera"
                };
                pictureDialog.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case 0:
                                    chooseGallery();
                                    break;
                                case 1:
                                    takePhoto();
                                    break;
                            }
                    }
                });
                pictureDialog.show();
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li=LayoutInflater.from(ProfileActivity.this);
                View promtV=li.inflate(R.layout.prompts,null);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ProfileActivity.this);
                alertDialog.setView(promtV);

                final EditText ed=(EditText)promtV.findViewById(R.id.a_pg);
                final EditText ed1=(EditText)promtV.findViewById(R.id.a_ug);
                final EditText ed2=(EditText)promtV.findViewById(R.id.a_ssc);
                ed.setText(pg.getText());
                ed1.setText(ug.getText());
                ed2.setText(ssc.getText());

                alertDialog.setCancelable(false)
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                pg.setText(ed.getText());
                                ug.setText(ed1.getText());
                                ssc.setText(ed2.getText());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog1=alertDialog.create();
                alertDialog1.show();


            }
        });


    }

    private void verifyPermissions(){
        Log.v("VerifyPermission","Checking Permission");

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[0])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[1])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                PERMISSIONS[2])== PackageManager.PERMISSION_GRANTED){

        } else {
            ActivityCompat.requestPermissions(ProfileActivity.this,PERMISSIONS,REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }

    private void chooseGallery() {
        Intent gallery=new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, GALLERY);
    }

    private void takePhoto(){
        Intent i =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,CAMERA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            Log.e("GalleryResponse", "" + data.getData());
            data.getData();
            Bitmap bmp = null;
            try {
                bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            profilepic.setImageBitmap(new RoundedImage(ProfileActivity.this).transform(bmp));
        } else if (requestCode == CAMERA) {
            Bitmap bmpp = (Bitmap) data.getExtras().get("data");
            profilepic.setImageBitmap(new RoundedImage(ProfileActivity.this).transform(bmpp));
        }
    }



}
