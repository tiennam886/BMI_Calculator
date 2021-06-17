package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText heighEt, weighEt;
    RadioGroup genderRg;
    Button btn;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heighEt= findViewById(R.id.height_et);
        weighEt= findViewById(R.id.weight_et);
        btn = findViewById(R.id.bmi_btn);
        genderRg = findViewById(R.id.gender_rg);

        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.boy_rb){
                    gender ="boy";

                }else{
                    gender="girl";
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightVal = heighEt.getText().toString().trim();
                String weightVal = weighEt.getText().toString().trim();
                float height = Float.parseFloat(heightVal);
                float weight = Float.parseFloat(weightVal);
                float bmi = calBMI(height, weight);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("gender", gender);
                startActivity(intent);
                }
        });
    }
    public float calBMI(float h, float w){
        float h_m = h/100;
        float bmi = w / (h_m * h_m);
        return bmi;
    }
}