package com.example.discountcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DEFAULT_CUSTOM_PERCENT = "25%";
    public static final String DEFAULT_VALUE = "0.00";
    public static final int DEFAULT_PROGRESS = 25;
    EditText itemPriceText;
    TextView customPercentText, discountValueText, finalPriceText;
    Button resetButton, calculateButton;
    RadioGroup radioGroup;
    RadioButton tenPercentRadio, fifteenPercentRadio, eighteenPercent, customPercent;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemPriceText = findViewById(R.id.itemPriceText);
        customPercentText = findViewById(R.id.customPercentText);
        discountValueText = findViewById(R.id.discountValueText);
        finalPriceText = findViewById(R.id.finalPriceText);

        radioGroup = findViewById(R.id.radioGroup);

        tenPercentRadio = findViewById(R.id.tenPercentRadio);
        fifteenPercentRadio = findViewById(R.id.fifteenPercentRadio);
        eighteenPercent = findViewById(R.id.eighteenPercent);
        customPercent = findViewById(R.id.customPercent);

        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);

        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(this);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                customPercentText.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.resetButton){
            itemPriceText.setText("");
            customPercentText.setText(DEFAULT_CUSTOM_PERCENT);
            discountValueText.setText(DEFAULT_VALUE);
            finalPriceText.setText(DEFAULT_VALUE);
            tenPercentRadio.setChecked(true);
            fifteenPercentRadio.setChecked(false);
            eighteenPercent.setChecked(false);
            customPercent.setChecked(false);
            seekBar.setProgress(DEFAULT_PROGRESS);
        }
        else if(v.getId() == R.id.calculateButton){
            String itemPrice = itemPriceText.getText().toString();
            if(itemPrice.isEmpty()){
                discountValueText.setText("");
                finalPriceText.setText("");
                Toast.makeText(this, "Enter Item Price", Toast.LENGTH_SHORT).show();
            }
            else {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                double price = Double.parseDouble(itemPrice);
                double discont, finalPrice;
                if(checkedId == R.id.tenPercentRadio){
                    discont = price * 0.1;
                } else if (checkedId == R.id.fifteenPercentRadio) {
                    discont = price * 0.15;
                }else if (checkedId == R.id.fifteenPercentRadio) {
                    discont = price * 0.15;
                }else {
                    discont = price * seekBar.getProgress() * 0.01;
                }
                finalPrice = price - discont;
                discountValueText.setText(String.valueOf(discont));
                finalPriceText.setText(String.valueOf(finalPrice));
            }
        }
    }
}