package com.example.myarlist;//Array List Demonstration

import android.app.Activity;
import android.os.*;
import java.util.ArrayList;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Object> arl = new ArrayList<Object>();
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(20);
        Integer i3 = new Integer(30);
        Integer i4 = new Integer(40);
//        String s1 = "my string";

        System.out.println("The content of the Arraylist is: " + arl);
        System.out.println("The size of the Arraylist is: " + arl.size());

        arl.add(i1);
        arl.add(i2);
        arl.add(i3);

        System.out.println("The conent of the Arraylist is: " + arl);
        System.out.println("The size of the Arraylist is: " + arl.size());

        arl.add(i1);
        arl.add(i2);
        arl.add(i3);
        arl.add(i4);
        Integer i5 = new Integer(50);
        arl.add(i5);


        System.out.println("The conent of the Arraylist is: " + arl);
        System.out.println("The size of the Arraylist is: " + arl.size());

        arl.remove(3);

        System.out.println("The conent of the Arraylist is: " + arl);
        System.out.println("The size of the Arraylist is: " + arl.size());

        ArrayList<Object> imaClone = new ArrayList<Object>();//a new list
        imaClone = (ArrayList<Object>)arl.clone();

        System.out.println("The content of clone A is: " + imaClone);
        System.out.println("The size arrayList A is: "+imaClone.size());
        System.out.println("The content of arrayList B is: "+arl);
        System.out.println("The size of arrayList B is: "+arl.size());



    }//end onCreate

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
