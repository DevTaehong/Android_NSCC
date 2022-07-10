package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button btnAdd, btnSub, btnMulti, btnDivision, btnNegPos,
            btnCalculate, btnDecimal, btnRemove, btnClear,
            btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven,
            btnEight, btnNine, btnZero;
    EditText edDisplay;


    boolean BooleanAddition, BooleanSubtract, BooleanMultiplication, BooleanDivision;
    float leftNum, rightNum, negNum;

    calc myCalc = new calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSubtraction);
        btnMulti = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnNegPos = findViewById(R.id.btnNegPos);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnRemove = findViewById(R.id.btnRemove);
        btnClear = findViewById(R.id.btnClear);
        edDisplay = findViewById(R.id.tvDisplay);



        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "9");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText(edDisplay.getText() + "0");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0){
                    if (edDisplay == null) {
                        edDisplay.setText("");
                    } else {
                        leftNum = Float.parseFloat(edDisplay.getText() + "");
                        myCalc.setLeftNum(leftNum);
                        BooleanAddition = true;
                        edDisplay.setText(null);
                    }//end else
                }//end if
            }//end onClick
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0){
                    leftNum = Float.parseFloat(edDisplay.getText() + "");
                    myCalc.setLeftNum(leftNum);
                    BooleanSubtract = true;
                    edDisplay.setText(null);
                }
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0) {
                    leftNum = Float.parseFloat(edDisplay.getText() + "");
                    myCalc.setLeftNum(leftNum);
                    BooleanMultiplication = true;
                    edDisplay.setText(null);
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0){
                    leftNum = Float.parseFloat(edDisplay.getText() + "");
                    myCalc.setLeftNum(leftNum);
                    BooleanDivision = true;
                    edDisplay.setText(null);
                }
            }
        });

        btnNegPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = edDisplay.getText().toString(); //Source: https://www.youtube.com/watch?v=yk45jKgdpw8
                if (value.length() > 0) {
                    edDisplay.setText(value);
                    negNum = Float.parseFloat(edDisplay.getText() + "");
                    myCalc.setNegNum(negNum);
                    edDisplay.setText(myCalc.NegPos() + "");
                }//end if
            }//end onClick
        });//end setOnClickListener


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0) {
                    rightNum = Float.parseFloat(edDisplay.getText() + "");
                    myCalc.setRightNum(rightNum);

                    if (BooleanAddition == true) {
                        edDisplay.setText(myCalc.addition() + "");
                        BooleanAddition = false;
                    }

                    if (BooleanSubtract == true) {
                        edDisplay.setText(myCalc.Subtraction() + "");
                        BooleanSubtract = false;
                    }

                    if (BooleanMultiplication == true) {
                        edDisplay.setText(myCalc.Multiplication() + "");
                        BooleanMultiplication = false;
                    }

                    if (BooleanDivision == true) {
                        if (leftNum == 0 || rightNum == 0) {
                            edDisplay.setText("NaN");
                        } else {
                            edDisplay.setText(myCalc.Division() + "");
                            BooleanDivision = false;
                        }//end else
                    }//end nested if

                }//end  if
            }//end onClick
        });//end inner class

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edDisplay.setText("");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edDisplay.getText().toString();
                if (value.length() > 0){
                    if (value.lastIndexOf(".")==-1)
                    edDisplay.setText(edDisplay.getText() + ".");
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = edDisplay.getText().toString(); //Source: https://www.youtube.com/watch?v=yk45jKgdpw8
                if (value.length() > 0){
                    value = value.substring(0,value.length()-1);
                    edDisplay.setText(value);
                }//end if
            }//end onClick
        });//end setOnClickListener



    }//end onCreate












}