package com.example.hashmap;//A hash map is a data structure that uses a mathematical hash function
//to map identifying value, known as keys, to associate values
//e.g. mapping a name to a telephone number

import android.app.Activity;
import android.graphics.Color;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import android.content.*;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map = new HashMap<>();//create map
        map.put("Color1", "Red");//place key and associate data in map
        map.put("Color2", "Blue");
        map.put("Color3", "Green");
        map.put("Color4", "White");

        String s = map.get("Color1");
        System.out.println(s);

        Iterator myVeryOwnIterator = map.keySet().iterator();


        Iterator it = map.values().iterator();


        while (it.hasNext()){
            String text = it.next().toString();
            System.out.println(text);
        }

        Iterator<String> myIterator = map.values().iterator();//create iterator
        Context context = getApplicationContext();

        while (myIterator.hasNext())//display colors using toast
        {
            Toast.makeText(getBaseContext(),myIterator.next(),Toast.LENGTH_SHORT).show();
            CharSequence text = myIterator.next();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }//end while

//        map.get("Color1");//to take a key and grab an associate value back
    }//end onCreate
}//end MainActivity
