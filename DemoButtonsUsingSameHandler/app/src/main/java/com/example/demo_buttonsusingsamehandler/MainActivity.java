//Note: You may register a handler with it's control either in Java or XML
////To register onClick in xml (layout) android:onClick="onBtnClicked">

package com.example.demo_buttonsusingsamehandler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
//import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btnOne, btnTwo, btnThree;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);

        //set all events to SAME listener class
        btnOne.setOnClickListener(onButtonClicked);
        btnTwo.setOnClickListener(onButtonClicked);
        btnThree.setOnClickListener(onButtonClicked);
    }//end onCreate

    public View.OnClickListener onButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnOne:
                    Toast.makeText(getApplicationContext(),"Button One" + "-", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnTwo:
                    Toast.makeText(getApplicationContext(),"Button Two" + "-", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnThree:
                    Toast.makeText(getApplicationContext(),"Button Three" + "-", Toast.LENGTH_SHORT).show();
                    break;
            }//end switch
        }//end method onClick
    };//end inner class

}//end class
