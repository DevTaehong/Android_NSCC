//Shared Preferences Demo
//Sp's are a means of storing primitive data like in
//in a pp local xml file. It uses key value pairs t
package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.*;//seekbar, change listener
import android.widget.SeekBar; //OnSeekBarChangeListener
import android.view.*;
import android.view.View.*;
import android.content.*;//Shared pref

public class MainActivity extends AppCompatActivity{

    private Button btnText;
    private SeekBar sbText;
    private EditText etText;
    private SharedPreferences prefs;
    private static final String FONT_SIZE_KEY = "fontsize";
    private static final String TEXT_VALUE_KEY = "textvalue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnText = (Button)findViewById(R.id.btnText);
        sbText = (SeekBar)findViewById(R.id.sbText);
        etText = (EditText)findViewById(R.id.etText);

        prefs=getPreferences(MODE_PRIVATE);
        float fontSize = prefs.getFloat(FONT_SIZE_KEY,8);//8 is default
        sbText.setProgress((int)fontSize);
        etText.setText(prefs.getString(TEXT_VALUE_KEY,""));//"" is default
        etText.setTextSize(TypedValue.COMPLEX_UNIT_PX,sbText.getProgress());//use TypedValue for PX/SP conversion

        btnText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                //save the values String and Font size
                editor.putFloat(FONT_SIZE_KEY,etText.getTextSize());
                editor.putString(TEXT_VALUE_KEY,etText.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });

        sbText.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                etText.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);//use TypedValue for PX/SP conversion
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }//end onCreate
}//end class
