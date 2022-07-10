package com.example.demo_tipcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.*;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
    myMathClass mmc = new myMathClass();//demo of business class (clean)

    //constants used for saving
    private static final String BILL_TOTAL = "BILL TOTAL";
    private static final String CUSTOM_PERCENT = "CUSTOM PERCENT";

    private double currentBillTotal;
    private int currentCustomPercent;

    //step#1
    private EditText tip10EditText;
    private EditText total10EditText;
    private EditText tip15EditText;
    private EditText total15EditText;
    private EditText tip20EditText;
    private EditText total20EditText;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;
    private EditText billEditText;
    private TextView customTipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mmc.square()
        //Step #2
        tip10EditText = (EditText)findViewById(R.id.tip10EditText);
        total10EditText = (EditText)findViewById(R.id.total10EditText);
        tip15EditText = (EditText)findViewById(R.id.tip15EditText);
        total15EditText = (EditText)findViewById(R.id.total15EditText);
        tip20EditText = (EditText)findViewById(R.id.tip20EditText);
        total20EditText = (EditText)findViewById(R.id.total20EditText);
        tipCustomEditText = (EditText)findViewById(R.id.tipCustomEditText);
        totalCustomEditText = (EditText)findViewById(R.id.totalCustomEditText);
        billEditText = (EditText)findViewById(R.id.billEditText);
        customTipTextView  = (TextView) findViewById(R.id.customTipTextView);

        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);

        billEditText.addTextChangedListener(billEditTextWatcher);
    }//end method onCreate

    private void updateCustom(){//method for other than 10,15,20
        customTipTextView.setText(currentCustomPercent +"%");
        double customTipAmount = currentBillTotal * currentCustomPercent *.01;
        double customTotalAmount = currentBillTotal + customTipAmount;
        tipCustomEditText.setText(String.format("%.02f",customTipAmount));
        totalCustomEditText.setText(String.format("%.02f",customTotalAmount));
    }//this method called by handler

    private void updateStandard(){//method for 10,15,20
        double tenPercentTip = currentBillTotal * .1;
        double tenPercentTotal = currentBillTotal + tenPercentTip;
        tip10EditText.setText(String.format("%.02f",tenPercentTip));
        total10EditText.setText(String.format("%.02f",tenPercentTotal));

        double fifteenPercentTip = currentBillTotal * .15;
        double fifteenPercentTotal = currentBillTotal + fifteenPercentTip;
        tip15EditText.setText(String.format("%.02f",fifteenPercentTip));
        total15EditText.setText(String.format("%.02f",fifteenPercentTotal));

        double twentyPercentTip = currentBillTotal * .2;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;
        tip20EditText.setText(String.format("%.02f",twentyPercentTip));
        total20EditText.setText(String.format("%.02f",twentyPercentTotal));
    }//this method called by handler

    private OnSeekBarChangeListener customSeekBarListener =
            new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    currentCustomPercent = seekBar.getProgress();
                    updateCustom();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };//end inner class

    private TextWatcher billEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                currentBillTotal = Double.parseDouble(s.toString());
            } catch (NumberFormatException e) {
                currentBillTotal = 0.0;
            }

            updateStandard();
            updateCustom();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };//end inner class


}//end class