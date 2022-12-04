package com.nextgencoder.miniproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Result extends AppCompatActivity {

    private TextView results, detail1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        results = findViewById(R.id.output1);
        Double bmi = (Double) getIntent().getDoubleExtra("bmi", 0.0);
        Double bmr = (Double) getIntent().getDoubleExtra("bmr",0.0);
        results.setText("BMI : " + bmi+"\n\n"+ "BMR : " + bmr);

        detail1 = findViewById(R.id.details);
        if(bmi < 18.5){
            detail1.setText("Under-Weighted");
        }else if(18.5 < bmi && bmi < 24.9){
            detail1.setText("Healthy Weighted");
        }else if(24.9 < bmi && bmi < 29.9){
            detail1.setText("Over Weighted");
        }else if(29.9 < bmi && bmi < 34.9){
            detail1.setText("Obese Class I");
        }else if(34.9 < bmi && bmi < 39.9){
            detail1.setText("Obese Class II");
        }else {
            detail1.setText("Obese Class III");
        }

    }



}