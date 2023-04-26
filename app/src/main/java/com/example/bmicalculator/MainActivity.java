package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText weightText;
    private EditText heightText;
    private Button CalculateButton;
    private Button CalculateAgainButton;
    private TextView resultText;
    private TextView BMIText;
    private TextView bodyTypeText;
    private double weight;
    private double height;
    private double check;
    private String bodyType;
    private View layout3;
    private View layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightText = findViewById(R.id.weightEditText);
        heightText = findViewById(R.id.heightEditText);
        CalculateButton = findViewById(R.id.calculateButton);
        CalculateAgainButton = findViewById(R.id.calculatAgainButton);
        resultText = findViewById(R.id.resultText);
        BMIText = findViewById(R.id.BMIText);
        bodyTypeText = findViewById(R.id.typeText);
        layout3 = findViewById(R.id.layout3);
        layout2 = findViewById(R.id.layout2);
        layout3.setVisibility(View.GONE);

        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = Double.parseDouble(weightText.getText().toString());
                height = Double.parseDouble(heightText.getText().toString());
                double square = (height/100)*(height/100);
                check = weight/square;
                check = Math.floor(check*10)/10;

                if(check < 18.5)
                    bodyType = "Underweight";
                else if(check < 24.9)
                    bodyType = "Normal weight";
                else if(check < 29.9)
                    bodyType = "Overweight";
                else
                    bodyType = "Obesity";

                BMIText.setText(Double.toString(check));
                bodyTypeText.setText(bodyType);
                layout2.setVisibility(View.GONE);
                layout3.setVisibility(View.VISIBLE);
            }
        });

        CalculateAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightText.setText("");
                heightText.setText("");
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.GONE);
            }
        });
    }

}