//Demo of an Internal Write, Internal Read, and a res/raw read (read only)

// To create a RAW folder: Right click on app. click 'new' on popup then click on android resource director
// (a new window will be appear) change resource type to raw - Create a text file "text.txt" with content and
// place it in the raw folder.
// It is usually best to let the OS decide where to store your files is Res/raw is not being used.


package com.example.myinternaldemo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.*;
import android.view.*;
import java.io.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btnWriteInternal;
    Button btnReadInternal;
    Button btnReadInternalRaw;
    final String IOTAG = "IO Error";
    final String GTAG = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWriteInternal = findViewById(R.id.btnWriteInternal);
        btnReadInternal = findViewById(R.id.btnReadInternal);
        btnReadInternalRaw = findViewById(R.id.btnReadInternalRaw);

        //WRITE to INTERNAL storage
        btnWriteInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    //FileOutputStream fileOut = openFileOutput("myTextFile.txt", MODE_PRIVATE); //non-append write
                    FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_APPEND);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    System.out.println("File open for write");
                    outputWriter.write("I woz here!");
                    //outputWriter.flush();//only if you use again without close or re-instancing
                    outputWriter.close();

                    //display file saved message
                    System.out.println("File saved and closed");
                }
                catch (IOException e)
                {
                    Log.e(IOTAG,"File IO error");
                }
                catch (Exception e)
                {
                    String msg = e.getMessage();
                    Log.e(GTAG,"General Error");
                }
            }//end onClick
        });////end btn Listener


        //READ INTERNAL
        btnReadInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int READ_BLOCK_SIZE = 100;
                try
                {
                    FileInputStream fileIn = openFileInput("mytextfile.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    char[] inputBuffer= new char[READ_BLOCK_SIZE];
                    String s="";
                    int charRead;

                    while ((charRead=InputRead.read(inputBuffer))>0) { //also an eof test
                        // char to string conversion
                        String readstring = String.copyValueOf(inputBuffer,0,charRead);
                        s += readstring;
                    }
                    InputRead.close();
                    System.out.println(s);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }//end onClick
        });//end btn listener


        //READ INTERNAL using RAW & Buffered Reader - note res/raw is read only in Android
        btnReadInternalRaw.setOnClickListener(new View.OnClickListener() {   //This will be used in assignment 2
            @Override
            public void onClick(View view) {
                String str = null;
                BufferedReader br = null;
                try {
                    InputStream is = getResources().openRawResource(R.raw.text);
                    br = new BufferedReader(new InputStreamReader(is));
                    System.out.println("File in RAW is open");

                    while ((str = br.readLine()) != null) { // eof test
                        System.out.println(str);
                    }

                    is.close();
                    System.out.println("File in RAW is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });//end btn Listener

    }//end onCreate
}//end class Main
