package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FindResultActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button Back,Update;
    EditText varos,orszag,lakossag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_result);
        init();
        rogzit();
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vissza=new Intent(FindResultActivity.this,MainActivity.class);
                startActivity(vissza);
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rogzit();
            }
        });
    }
    private void init(){
        db =new DatabaseHelper(FindResultActivity.this);
        lakossag=findViewById(R.id.lakossag_input);
        orszag=findViewById(R.id.orszag_input);
        varos=findViewById(R.id.varos_input);
        Back=findViewById(R.id.Back);
        Update=findViewById(R.id.Update);
    }
    private void rogzit(){
        String lakossag_input=lakossag.getText().toString().trim();
        String orszag_input=orszag.getText().toString().trim();
        String varos_input=varos.getText().toString().trim();
    }
}