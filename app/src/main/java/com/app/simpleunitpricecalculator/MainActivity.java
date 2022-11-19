package com.app.simpleunitpricecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



// variables declaration
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editPrice1, editPrice2, editContent1, editContent2;
    String stringPrice1, stringPrice2, stringContent1, stringContent2, resultSummary, resultResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.buttonCompute);
        btnCompute.setOnClickListener(this);

        Button btnClear = (Button) findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrice1.getText().clear();
                editPrice2.getText().clear();
                editContent1.getText().clear();
                editContent2.getText().clear();
                editPrice1.requestFocus();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult() {
        editPrice1 = findViewById(R.id.editPrice1);
        editPrice2 = findViewById(R.id.editPrice2);
        editContent1 =  findViewById(R.id.editContent1);
        editContent2 = findViewById(R.id.editContent2);

        if (editPrice1.getText().toString().isEmpty() || editContent1.getText().toString().isEmpty() || editPrice2.getText().toString().isEmpty() || editContent2.getText().toString().isEmpty()) {
            stringPrice1 = "0";
            stringPrice2 = "0";
            stringContent1 = "0";
            stringContent2 = "0";
        } else {
            stringPrice1 = editPrice1.getText().toString();
            stringPrice2 = editPrice2.getText().toString();
            stringContent1 = editContent1.getText().toString();
            stringContent2 = editContent2.getText().toString();
        }

        double rawPrice1 = Double.parseDouble(stringPrice1);
        double rawPrice2 = Double.parseDouble(stringPrice2);
        double rawContent1 = Double.parseDouble(stringContent1);
        double rawContent2 = Double.parseDouble(stringContent2);

        double resultRatio1 = (rawPrice1 / rawContent1);
        double resultRatio2 = (rawPrice2 / rawContent2);

        double resultPercentSavings = (1 - 1 / (resultRatio2 / resultRatio1)) * 100;
        double resultPercentCharge = (resultRatio2 / resultRatio1 - 1) * 100;

        //  condition
        if (resultRatio1 > resultRatio2) {
            resultResponse = "\nPick PRODUCT B, its cheaper!";
        }
        else if (resultRatio1 < resultRatio2) {
            resultResponse = "\nPick PRODUCT A, its cheaper!";
        }
        else {
            resultResponse = "\nBoth products' values are the same!";
        }


        // dialog text
        resultSummary = "Price value per unit (a): " + String.format("%.2f", resultRatio1)+ "\nPrice value per unit (b): " + String.format("%.2f", resultRatio2) + "\n\n"  + resultResponse + "\n\nSaving in percent: " + String.format("%.2f", resultPercentSavings) + "%\n\nAdditional charge in percent: " + String.format("%.2f", resultPercentCharge) + "%";

        Bundle args = new Bundle();
        args.putString("result", resultSummary);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(), "Display Result");
    }
}