package com.shubham.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextLaborCost, editTextMaterialCost;
    Button calculateButton;
    TextView textViewSubTotal, textViewTax, textViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLaborCost = (EditText) findViewById(R.id.editTextLaborCost) ;
        editTextMaterialCost = (EditText) findViewById(R.id.editTextMaterialCost) ;

        calculateButton = (Button) findViewById(R.id.calculateButton) ;

        textViewSubTotal = (TextView) findViewById(R.id.textViewSubTotal);
        textViewTax = (TextView) findViewById(R.id.textViewTax);
        textViewTotal = (TextView) findViewById(R.id.textViewTotal);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double subTotalAmount = Double.parseDouble(editTextLaborCost.getText().toString()) + Double.parseDouble(editTextMaterialCost.getText().toString());;
                double taxAmount = subTotalAmount * 5 / 100.0;
                double totalAmount = subTotalAmount + taxAmount;

                textViewSubTotal.setText("$" + String.format("%.2f", subTotalAmount));
                textViewTax.setText("$" + String.format("%.2f", taxAmount));
                textViewTotal.setText("$" + String.format("%.2f", totalAmount));
            }
        });
    }
}