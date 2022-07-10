package com.example.quizprep;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*; //views ie controls

public class MainActivity extends AppCompatActivity {
    Button btnHello,btnPressBus; //obj var for controls
    TextView tvHello;
    BusClass myBC = new BusClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHello = findViewById(R.id.btnHello);//instances and links to xml
        btnPressBus = findViewById(R.id.btnPressBus);
        tvHello = findViewById(R.id.tvOutput);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHello.setText("Hello");
            }
        });//annon inner class

        btnPressBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHello.setText(myBC.getBusText());
            }
        });
    }//end OnCreate
}//end class