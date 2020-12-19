package com.example.lab2_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rtugeek.android.colorseekbar.ColorSeekBar;

import java.util.ArrayList;

public class DataPage extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    public EditText et_number;
    private ImageView imageCall;
    private EditText ProNo, et_name;
    private Button addButton, cancelButton;
    private RadioButton rd_female, rd_male;
    private RatingBar ratingBar;
    private ColorSeekBar colorSeekBar;
    private TextView tv_color;
    int edit_color;

    private String name, gender, rating, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_page);

        et_name = findViewById(R.id.name);
        addButton = findViewById(R.id.btn_add);
        cancelButton = findViewById(R.id.btn_cancel);
        rd_female = findViewById(R.id.rd_female);
        rd_male = findViewById(R.id.rd_male);
        ratingBar = findViewById(R.id.ratingBar);
        et_number = findViewById(R.id.number);
        imageCall = findViewById(R.id.image_call);
        tv_color = findViewById(R.id.tv_color);

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone = et_number.getText().toString();
                if (Phone.isEmpty()) {
                    Toast.makeText(DataPage.this, "Please Enter Phone Number!", Toast.LENGTH_SHORT).show();
                } else {
                    String s = "tel:" + Phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et_name.getText().toString();
                if (rd_female.isChecked()) {
                    gender = "Female";

                } else {
                    gender = "Male";
                }
                rating = String.valueOf(ratingBar.getRating());
                number = et_number.getText().toString();
                MainActivity.exampleList.add(new ExampleItem(R.drawable.ic_like,name,gender,rating,number,String.valueOf(edit_color)));

                Toast.makeText(DataPage.this, "Item added!", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        colorSeekBar = findViewById(R.id.colorSlider);
        colorSeekBar.setMaxPosition(100);
        colorSeekBar.setColorSeeds(R.array.material_colors); // material_colors is defalut included in res/color,just use it.
        colorSeekBar.setColorBarPosition(10); //0 - maxValue
        colorSeekBar.setAlphaBarPosition(10); //0 - 255
        colorSeekBar.setPosition(10,10); // An easier way to set ColorBar and AlphaBar
        colorSeekBar.setShowAlphaBar(true);
        colorSeekBar.setBarHeight(5); //5dpi
        colorSeekBar.setThumbHeight(30); //30dpi
        colorSeekBar.setBarMargin(10); //set the margin between colorBar and alphaBar 10dpi


        colorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
                tv_color.setTextColor(color);
                edit_color = color;
            }
        });


    }

}
