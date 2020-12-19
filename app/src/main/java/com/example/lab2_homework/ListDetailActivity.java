package com.example.lab2_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ListDetailActivity extends AppCompatActivity {
    private EditText tv_name, tv_gender, tv_rating, tv_number;
    private String name, gender, rating, number,index_number;
    private String edit_name, edit_gender, edit_rating, edit_number;
    private Button btn_cancel, btn_modify, btn_dial, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getIntent().getStringExtra("name");
        gender =getIntent().getStringExtra("gender");
        rating =getIntent().getStringExtra("rating");
        number =getIntent().getStringExtra("number");
        index_number =getIntent().getStringExtra("index_number");

        setContentView(R.layout.activity_list_detail);

        tv_name = findViewById(R.id.name);
        tv_gender = findViewById(R.id.gender);
        tv_rating = findViewById(R.id.rating);
        tv_number = findViewById(R.id.number);

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_delete = findViewById(R.id.btn_delete);
        btn_dial = findViewById(R.id.btn_dial);
        btn_modify = findViewById(R.id.btn_modify);


        tv_name.setText(name);
        tv_gender.setText(gender);
        tv_rating.setText(rating);
        tv_number.setText(number);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(index_number);
                MainActivity.exampleList.remove(a);
                Toast.makeText(ListDetailActivity.this, "Deleted!", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        btn_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int a = Integer.parseInt(index_number);

                    edit_name = tv_name.getText().toString();
                    edit_gender = tv_gender.getText().toString();
                    edit_rating = tv_rating.getText().toString();
                    edit_number = tv_number.getText().toString();

                    MainActivity.exampleList.set(a,new ExampleItem(R.drawable.ic_like,edit_name,edit_gender,edit_rating,edit_number,"-2132549313"));

                    Toast.makeText(ListDetailActivity.this, "Modified!", Toast.LENGTH_SHORT).show();
                    finish();

                }
        });


    }
}