package com.example.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"On Create",Toast.LENGTH_LONG).show();
    }//end onCreate

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,"On Start",Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,"on Resume",Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(MainActivity.this,"on Pause",Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(MainActivity.this,"on Restart",Toast.LENGTH_LONG).show();
    }//end onStart

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "on Stop", Toast.LENGTH_LONG).show();
    } //end onStop

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "on Destroy", Toast.LENGTH_LONG).show();
    } //end onStop

}//end class