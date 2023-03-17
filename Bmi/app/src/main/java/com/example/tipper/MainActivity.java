package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import java.text.DecimalFormat;
import java.text.NumberFormat; // for currency formatting

public class MainActivity extends AppCompatActivity {
    private double weight = 0.0;
    private double height = 0.15;
    //TextViews definitions
    private TextView heightTextView;
    private TextView weightTextView;


    private TextView totalTextView;

    //method onCreate, most important one
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));

        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

    }

    private void calculate() {
        DecimalFormat df = new DecimalFormat("#.##");

        double total = (weight / (height * height)) * 100;


        totalTextView.setText(String.format(df.format(total) + ""));
    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies weight or height field, or both
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString()) / 100.0;
                weightTextView.setText(String.format(weight + ""));
            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(String.format(height + ""));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}
