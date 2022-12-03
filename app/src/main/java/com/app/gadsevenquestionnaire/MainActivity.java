package com.app.gadsevenquestionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



// variables declaration
public class MainActivity extends AppCompatActivity  {
    private Button button;
    public static int anxietyScore = 0;
    EditText editPrice1, editPrice2, editContent1, editContent2;
    String stringPrice1, stringPrice2, stringContent1, stringContent2, resultSummary, resultResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityQuestion_One();
            }
        });
    }
    public void openActivityQuestion_One() {
        Intent intent = new Intent(MainActivity.this, OneActivity.class);
        startActivity(intent);
            }


//        Bundle args = new Bundle();
//        args.putString("result", resultSummary);
//
//        // Create a dialog instance
//        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
//        // Pass on dialog argument(args), the result
//        dialogFragmentImp.setArguments(args);
//        // Display the Dialog
//        dialogFragmentImp.show(getSupportFragmentManager(), "Display Result");
    }
