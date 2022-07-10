package com.example.demodatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.widget.*;
import android.database.*;//for cursor
import java.io.*;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            String destPath = "/data/data/" + getPackageName() +"/database/MyDB";
            //Alternate way to do destPath:
            //String destPath = Environment.getExternalStorageDirectory().getPath() +
            //getPackageName() + "/database/MyDB";
            File f = new File(destPath);
            if(!f.exists())
            {
                CopyDB(getBaseContext().getAssets().open("mydb"),
                        new FileOutputStream(destPath));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        DBAdapter db = new DBAdapter(this);

        //add a contact- CREATE
        db.open();
        long id = db.insertContact("Bob Loblaw","Bob@Loblaws.ca");
        id = db.insertContact("Sue Me","Sue@Me.ca");
        db.close();

        //get all contacts - READ
        db.open();
        Cursor c = db.getAllContact();
        if(c.moveToFirst())
        {
            do{
                DisplayContact(c);
            }while(c.moveToNext());
        }
        db.close();

        //get a single contact - READ
        db.open();
        c = db.getContact(2);
        if(c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this,"No contact found",Toast.LENGTH_LONG).show();

        db.close();

        //update a contact - UPDATE
        db.open();
        if(db.updateContact(1,"Bob Loblaw2","Bob@Loblaws2.ca"))
            Toast.makeText(this,"Update successful",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Update failed",Toast.LENGTH_LONG).show();
        db.close();

        //delete a contact - DELETE
        db.open();
        if(db.deleteContact(1))
            Toast.makeText(this,"Delete successful",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Delete failed",Toast.LENGTH_LONG).show();

        db.close();

    }//end method onCreate

    public void CopyDB(InputStream inputStream,OutputStream outputStream)
            throws IOException{
        //copy 1k bytes at a time
        byte[] buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer)) > 0)
        {
            outputStream.write(buffer,0,length);
        }
        inputStream.close();
        outputStream.close();

    }//end method CopyDB

    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2),
                Toast.LENGTH_LONG).show();
    }
}