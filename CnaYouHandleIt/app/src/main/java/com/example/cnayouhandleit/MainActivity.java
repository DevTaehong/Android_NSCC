package com.example.cnayouhandleit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    //Views
    Button btnDoToast;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up view
        btnDoToast = findViewById(R.id.btnDoToast);
        btnDoToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Toast called from handler",Toast.LENGTH_SHORT).show();
            }
        });//end listener
    }//end onCreate
}//end class