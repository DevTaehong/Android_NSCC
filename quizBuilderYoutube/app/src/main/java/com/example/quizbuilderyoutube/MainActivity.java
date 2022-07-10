package com.example.quizbuilderyoutube;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageView ivShowImage;
    ImageView ivMedals;
    ArrayList<String> courseNames = new ArrayList<>();
    ArrayList<String> newCourseNames = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    int index;
    Random random;
    String[] answers = new String[4];
    Button btn1, btn2, btn3, btn4;
    TextView tvPoints;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivShowImage = findViewById(R.id.ivShowImage);
        ivMedals = findViewById(R.id.ivMedals);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        courseNames.add("Android Game Development Surfaceview");
        courseNames.add("Android Game Development for Beginners");
        courseNames.add("Android Game Development Math Game");
        courseNames.add("Android Game Development Tutorial");
        courseNames.add("Android Sqlite Programming for Beginners");
        courseNames.add("Object-Oriented Programming Fundamentals");
        courseNames.add("jQuery Effects and Animations");
        index = 0;
        map.put(courseNames.get(0), "http://sandipbhattacharya.com/temp/images/android-game-development-surfaceview.jpg");
        map.put(courseNames.get(1), "http://sandipbhattacharya.com/temp/images/android-game-development-for-beginners.jpg");
        map.put(courseNames.get(2), "http://sandipbhattacharya.com/temp/images/android-game-development-math-game.jpg");
        map.put(courseNames.get(3), "http://sandipbhattacharya.com/temp/images/android-game-development-tutorial.jpg");
        map.put(courseNames.get(4), "http://sandipbhattacharya.com/temp/images/android-sqlite-programming-for-beginners.jpg");
        map.put(courseNames.get(5), "http://sandipbhattacharya.com/temp/images/object-oriented-programming-fundamentals.jpg");
        map.put(courseNames.get(6), "http://sandipbhattacharya.com/temp/images/jQuery-effects-and-animations.jpg");
        Collections.shuffle(courseNames);
        random = new Random();
        generateQuestions(index);
    }

    private void generateQuestions(int index) {
        // Bitmap bitmap = new ImageDownloader().execute(map.get(courseNames.get(index))).get();
        Glide.with(this)
                .asBitmap()
                .load(map.get(courseNames.get(index)))
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        ivShowImage.setImageBitmap(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
        newCourseNames = (ArrayList<String>) courseNames.clone();
        newCourseNames.remove(index);
        Collections.shuffle(newCourseNames);
        int correctAnswerPosition = random.nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == correctAnswerPosition)
                answers[i] = courseNames.get(index);
            else
                answers[i] = newCourseNames.get(i);
        }
        btn1.setText(answers[0]);
        btn2.setText(answers[1]);
        btn3.setText(answers[2]);
        btn4.setText(answers[3]);
        newCourseNames.clear();
    }

    public void answerSelected(View view) {
        String answer = ((Button) view).getText().toString();
        if (answer.equals(courseNames.get(index))) {
            points++;
            tvPoints.setText(points + "/7");
        }
        index++;
        if (index > courseNames.size() - 1) {
            ivShowImage.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            if (points == 7) {
                ivMedals.setImageResource(R.drawable.medals_gold);
            } else if (points == 6) {
                ivMedals.setImageResource(R.drawable.medals_silver);
            } else if (points == 5) {
                ivMedals.setImageResource(R.drawable.medals_bronze);
            }
        } else
            generateQuestions(index);
    }

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        HttpURLConnection httpURLConnection;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                Bitmap temp = BitmapFactory.decodeStream(inputStream);
                return temp;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                ivShowImage.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(), "Download Successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Download Error!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}