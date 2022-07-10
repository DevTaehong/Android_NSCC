package com.example.demobasicscals;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;//controls ie "views"
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BusClass myBC = new BusClass();
    Button btnStuff;
    TextView tvStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStuff = findViewById(R.id.btnstuff);
        tvStuff = findViewById(R.id.tvStuff);

        btnStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvStuff.setText(myBC.getStuff());
            }
        });//listeners are inner calsses
    }
}