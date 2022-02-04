package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private TextView orszag;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        lekerdezes();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main=new Intent(SearchResultActivity.this,MainActivity.class);
                startActivity(main);
                finish();

            }
        });
    }
    private void init(){
        orszag=findViewById(R.id.orszag_search);
        db =new DatabaseHelper(SearchResultActivity.this);
        search=findViewById(R.id.Update);
    }
    private void lekerdezes(){
        Cursor adat=db.adatLekerdezes();
        if(adat==null){
            Toast.makeText(this,"Hiba!",Toast.LENGTH_SHORT).show();
        }
        if(adat.getCount()==0){
            Toast.makeText(this,"Még nem történt feltöltés",Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuilder builder=new StringBuilder();
        while(adat.moveToNext()){
            builder.append("ID").append(adat.getInt(0)).append("\n");
            builder.append("varos").append(adat.getString(1)).append("\n");
            builder.append("orszag").append(adat.getString(2)).append("\n");
            builder.append("lakossag").append(adat.getInt(3)).append("\n");
        }
        orszag.setText(builder);
        Toast.makeText(this,"Sikeres lekérdezés",Toast.LENGTH_SHORT).show();
    }
}