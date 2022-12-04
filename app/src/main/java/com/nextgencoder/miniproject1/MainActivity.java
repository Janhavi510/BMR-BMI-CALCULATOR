package com.nextgencoder.miniproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText age, weight, height;
    private RadioGroup genderGroup;
    private RadioButton selectedBtn;
    private String selectedGender  = "MALE";
    private int weightK = 30;
    private int heightC = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.ageY);
        weight = findViewById(R.id.WeightK);
        height = findViewById(R.id.heightC);
        genderGroup = findViewById(R.id.radioG);

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idOfSelectedRB) {
                selectedBtn = findViewById( idOfSelectedRB);

            }
        });
    }

    public void Calculate(View view) {

        String ageStr = age.getText().toString();
        String wtStr = weight.getText().toString();
        String htStr = height.getText().toString();
        double ageNum = 0.0;

        try{
            ageNum = Double.parseDouble(ageStr);
            if(13 > ageNum || ageNum > 150){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException numberFormatException){
            Toast.makeText(this, "Enter AGE wisely", Toast.LENGTH_SHORT).show();
            return;
        }

        double wtNum = Double.parseDouble(wtStr);
        double htNum = Double.parseDouble(htStr);
        String Gender = selectedBtn.getText().toString();
        double bmi = wtNum/((htNum/100) * (htNum/100));
        double bmr;

        if(Gender.equals("Male")){
            bmr = 66.47 + (13.75 * wtNum) + (5.003 * htNum) - (6.755 * ageNum);
        } else {
            bmr = 655.1 + (9.563 * wtNum) + (1.85 * htNum) - (4.67 * ageNum);
        }


        Intent intent = new Intent(this, Result.class);
        intent.putExtra("bmi", bmi);
        intent.putExtra("bmr",bmr);
        startActivity(intent);
    }
    public void reset(View view) {

        age.setText("");
        weight.setText("");
        height.setText("");


    }
}