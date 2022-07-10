package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGotoQuiz;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGotoQuiz = findViewById(R.id.btnGotoQuiz);
        etName = findViewById(R.id.etName);

        btnGotoQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("second");
                Bundle extras = new Bundle();//create bundle object
                extras.putString("KEY", etName.getText() + "");//fill bundle
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }//end onCreate
}//end class