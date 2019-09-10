package com.kumararaja.techaptitude.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kumararaja.techaptitude.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner,spinner1;
    TextView signout,pg,ug,ssc;
    ImageView education,place,profilepic;


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

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String a = pg.getText().toString();
                String b=ug.getText().toString();
                String c=ssc.getText().toString();
                Intent i =new Intent(ProfileActivity.this,EditProfile.class);
                i.putExtra("pg",a);
                i.putExtra("ug",b);
                i.putExtra("ssc",c);
                startActivity(i);
*/
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected"+item, Toast.LENGTH_SHORT).show();
        switch (position){
    case 0:
        break;
    case 1:
        break;
    case 2:
        break;
    case 3:
        break;
}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
