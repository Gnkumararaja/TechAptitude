package com.kumararaja.techaptitude;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class Homepage extends AppCompatActivity {

    private Toolbar toolbar;

    Button practise, test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Aptitude");
        init();
        practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Homepage.this,TesttypeActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu) {
            Intent a = new Intent(this,ProfileActivity.class);
            startActivity(a);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void add() {
        Intent i = new Intent(Homepage.this, CategoryClass.class);
        startActivity(i);
    }

    private void init() {
        practise = findViewById(R.id.btn_practise);
        test = findViewById(R.id.btn_taketest);
    }


}
