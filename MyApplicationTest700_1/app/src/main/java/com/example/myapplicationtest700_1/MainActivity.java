package com.example.myapplicationtest700_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    Button btnHello; //declaring var for object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnHello.findViewById(R.id.btnHello1); //instance and link to xml button

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Handler
                System.out.println("I woz here");
                Log.w("tag","Hello");
            }
        });

        setContentView(R.layout.activity_main);
    }//end method onCreate


}//end class main