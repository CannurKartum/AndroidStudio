package com.example.lab2_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerChoice;
    Button btnAdd, btnList;

    static ArrayList<ExampleItem> exampleList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent1 = new Intent(this, DataPage.class);
        final Intent intent2 = new Intent(this, ListPage.class);

        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.female,"canseray","Female","5","5554443322","-2132549313"));



        spinnerChoice = findViewById(R.id.spinnerChoice);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Options,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoice.setAdapter(adapter);
        spinnerChoice.setOnItemSelectedListener(this);




        btnAdd = findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        btnList = findViewById(R.id.button2);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if(position == 1){
            Toast.makeText(MainActivity.this, "Application BackGround is White", Toast.LENGTH_SHORT).show();
        }if(position == 2){
            Toast.makeText(MainActivity.this, "Add button color is Pink", Toast.LENGTH_SHORT).show();
        }if(position == 3){
            Toast.makeText(MainActivity.this, "List button color is Blue", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
