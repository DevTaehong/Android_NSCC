//Note: MainActivity is automatically placed in manifest as the
//launcher class by Android Studio. Any other activities must be added
package com.example.demo_intentsbundles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnGotoTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGotoTwo = (Button) findViewById(R.id.btnGotoTwo);

        btnGotoTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("ActivityTwo");//create intent object
                Bundle extras = new Bundle();//create bundle object
                extras.putString("KEY", "Stuff from bundle");//fill bundle
                i.putExtras(extras);
                startActivityForResult(i, 1);
            }
        });

    }//end onCreate
}//end class
