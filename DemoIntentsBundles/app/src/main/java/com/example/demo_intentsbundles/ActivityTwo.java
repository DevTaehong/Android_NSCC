package com.example.demo_intentsbundles;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.content.Intent;
import android.view.*;
import android.widget.*;

public class ActivityTwo extends AppCompatActivity {
    //controls
    Button btnGotoMain;
    TextView tvFromBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tvFromBundle = findViewById(R.id.tvFromBundle);
        btnGotoMain = findViewById(R.id.btnGotoMain);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String s = extras.getString("KEY");
            tvFromBundle.setText(s);
        }


        btnGotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(ActivityTwo.this,MainActivity.class);
                startActivity(myintent);
            }
        });

    }//end onCreate
}//and class ActivityTwo
