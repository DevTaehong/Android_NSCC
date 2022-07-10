//Note: fade.xml source: https://www.androidhive.info/2013/06/android-working-with-xml-animations/
package com.example.demo_flagwave;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.view.animation.*;//animationUtils

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btnWave, btnFade;
    Integer[] imageId = {R.drawable.canflag};
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWave = findViewById(R.id.btnWave);
        btnFade = findViewById(R.id.btnFade);
        imageView = findViewById(R.id.imageViewWave);

        btnWave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(imageId[0]);
                waveFlag();
                imageView.setVisibility(View.INVISIBLE);
            }
        });

        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(imageId[0]);
                fadeFlag();
                imageView.setVisibility(View.INVISIBLE);
            }
        });
    }//end onCreate

    public void waveFlag()
    {
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.wave);
        imageView.startAnimation(myAnimation);// play the animation
    }//end waveFlag()

    public void fadeFlag()
    {
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
        imageView.startAnimation(myAnimation);// play the animation
    }//end fadeFlag()

}//end class Main