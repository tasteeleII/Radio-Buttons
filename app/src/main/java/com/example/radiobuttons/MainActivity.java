package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputBox;
    TextView outputText;
    Button button;
    RadioGroup radioGroup;
    RadioButton milesToKmsRadio;
    RadioButton kmsToMilesRadio;
    RadioButton poundsToKilosRadio;
    RadioButton kilosToPoundsRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBox = findViewById(R.id.inputBox);
        outputText = findViewById(R.id.outputText);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioGroup);
        milesToKmsRadio = findViewById(R.id.milesToKmsRadio);
        kmsToMilesRadio = findViewById(R.id.kmsToMilesRadio);
        poundsToKilosRadio = findViewById(R.id.poundsToKilosRadio);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = Double.parseDouble(inputBox.getText().toString());
                if (milesToKmsRadio.isChecked()) {
                    value = value * 1.6;
                } else if (kmsToMilesRadio.isChecked()) {
                    value = value / 1.6;
                }
                outputText.setText(String.format("%.2f", value));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                inputBox.setText("");
                outputText.setText("");
                if (i == R.id.milesToKmsRadio) {
                    inputBox.setHint("Miles");
                } else if (i == R.id.kmsToMilesRadio) {
                    inputBox.setHint("Kilometers");
                } else if (i == R.id.poundsToKilosRadio) {
                    inputBox.setHint("Pounds");
                } else if (i == R.id.kilosToPoundsRadio) {
                    inputBox.setHint("Kilograms");
                }
            }
        });
    }
}