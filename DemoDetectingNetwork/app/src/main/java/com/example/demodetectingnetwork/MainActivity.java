package com.example.demodetectingnetwork;

//Add the following to the AndroidManifest.xml just after the application tag
//<uses-permission android:name = "android.permission.INTERNET"/>
//<uses-permission android:name = "android.permission.ACCESS_NETWORK_STATE"/>


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;//Context;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.net.*;//network info


public class MainActivity extends AppCompatActivity {
    private static boolean wifiConnected = false;
    private static boolean mobileConnected = false;
    Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button)findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetworkConnection();
            }
        });
    }

    public void checkNetworkConnection(){
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if(activeInfo != null && activeInfo.isConnected()) {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        }
        if(wifiConnected){
            Toast.makeText(getBaseContext(),"wifi connected",Toast.LENGTH_LONG).show();
        }else if (mobileConnected){
            Toast.makeText(getBaseContext(),"mobile connected",Toast.LENGTH_LONG).show();
        }
    }//end check()

}// end class