package com.app.gadsevenquestionnaire;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class FiveActivity extends AppCompatActivity implements View.OnClickListener  {

    public static int anxietyScore = FourActivity.anxietyScore;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);

        btn1 = findViewById(R.id.button_not_at_all);
        btn2 = findViewById(R.id.button_several_days);
        btn3 = findViewById(R.id.button_more_than_half_days);
        btn4 = findViewById(R.id.button_nearly_every_day);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view)  {
        switch (view.getId()){
            case R.id.button_not_at_all:
                anxietyScore = FourActivity.anxietyScore;
//                Toast.makeText(this, "Anxiety Score:" + anxietyScore, Toast.LENGTH_SHORT).show();
                openActivityQuestion_Six();
                break;

            case R.id.button_several_days:
                anxietyScore = FourActivity.anxietyScore + 1;
//                Toast.makeText(this, "Anxiety Score:" + anxietyScore, Toast.LENGTH_SHORT).show();
                openActivityQuestion_Six();
                break;

            case R.id.button_more_than_half_days:
                anxietyScore = FourActivity.anxietyScore + 2;
//                Toast.makeText(this, "Anxiety Score:" + anxietyScore, Toast.LENGTH_SHORT).show();
                openActivityQuestion_Six();
                break;

            case R.id.button_nearly_every_day:
                anxietyScore = FourActivity.anxietyScore + 3;
//                Toast.makeText(this, "Anxiety Score:" + anxietyScore, Toast.LENGTH_SHORT).show();
                openActivityQuestion_Six();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
    public void openActivityQuestion_Six() {
        Intent intent = new Intent(FiveActivity.this, SixActivity.class);
        startActivity(intent);
    }
}
