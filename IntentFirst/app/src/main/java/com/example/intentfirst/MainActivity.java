package com.example.intentfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;//intents
import android.net.Uri;//for URLs
import android.provider.ContactsContract;//contacts manager



public class MainActivity extends AppCompatActivity {
    //Controls
    Button btnBrowser,btnPhone,btnContacts,btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnPhone = findViewById(R.id.btnPhone);
        btnContacts = findViewById(R.id.btnContacts);
        btnMap = findViewById(R.id.btnMap);

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.nscc.ca"));
                startActivity(i);
            }
        });//end handler

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_CALL,
//                        Uri.parse("tel:9021234567"));

                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9021234567"));
                startActivity(i);
            }
        });//end handler

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivity(i);
            }
        });//end handler

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapIntentUri = Uri.parse("geo:44.651070,-63.582687");
                Intent i = new Intent(Intent.ACTION_VIEW,mapIntentUri);
                i.setPackage("com.google.android.apps.maps");
                if (i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }//end if
            }
        });//end handler

    }
}