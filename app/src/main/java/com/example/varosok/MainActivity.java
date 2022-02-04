package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button update,search;
    private EditText orszag;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        update.setOnClickListener(new View.OnClickListener() { //új város felvétele
            @Override
            public void onClick(View view) {
                Intent kereses=new Intent(MainActivity.this,FindResultActivity.class);
                startActivity(kereses);
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() { //keresés
            @Override
            public void onClick(View view) {
                Intent feltolt=new Intent(MainActivity.this,SearchResultActivity.class);
                startActivity(feltolt);
                finish();
            }
        });

    }
    public void init(){
        orszag=findViewById(R.id.orszag);
        search=findViewById(R.id.Search);
        update=findViewById(R.id.Update);
        db =new DatabaseHelper(MainActivity.this);
    }
}