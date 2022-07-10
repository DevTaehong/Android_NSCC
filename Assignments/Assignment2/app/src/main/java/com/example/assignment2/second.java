package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class second extends AppCompatActivity {

    private TextView tvNameInSecond;
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4 , btnAgain;
    private int mScore = 0;
    int index = 0;
    Random random;
    String[] answers = new String[4];
    String str;
    BufferedReader br;
    ArrayList<String> alTerms = new ArrayList<>(), alDefinitions = new ArrayList<>();
    ArrayList<String> newDefinitions = new ArrayList<>();
    Map<String, String> map = new HashMap<>();//create map

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        tvNameInSecond = findViewById(R.id.tvNameInSecond);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        btnAgain = findViewById(R.id.btnAgain);
        btnAgain.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String s = extras.getString("KEY");
            tvNameInSecond.setText("Welcome To The " + s + "'s Quiz!");
        }

        try {
            InputStream is = getResources().openRawResource(R.raw.text);
            br = new BufferedReader(new InputStreamReader(is));
            for (int i=0; i<20; i++){
                if ((str = br.readLine()) != null){
                    if (i<10){
                        alTerms.add(str);
                    }
                    else {
                        alDefinitions.add(str);
                    }// end if
                }//end if
            }//end for
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        for (int i=0; i<10; i++){
            map.put(alDefinitions.get(i), alTerms.get(i));
        }
        random = new Random();
        Collections.shuffle(alDefinitions);
        generateQuestions(index);
    }//end onCreate

    //Source: https://github.com/sandipapps/Online-Quiz-App
    private void generateQuestions(int index) {
        String terms = map.get(alDefinitions.get(index));
        mQuestionView.setText(terms);
        newDefinitions = (ArrayList<String>) alDefinitions.clone();
        newDefinitions.remove(index);
        Collections.shuffle(newDefinitions);
        int correctAnswerPosition = random.nextInt(4);
        for (int i=0; i<4; i++){
            if(i == correctAnswerPosition)
                answers[i] = alDefinitions.get(index);
            else
                answers[i] = newDefinitions.get(i);
        }
        mButtonChoice1.setText(answers[0]);
        mButtonChoice2.setText(answers[1]);
        mButtonChoice3.setText(answers[2]);
        mButtonChoice4.setText(answers[3]);
        newDefinitions.clear();
    }

    public void answerSelected(View view){
        String answer = ((Button)view).getText().toString();
        if(answer.equals(alDefinitions.get(index))){
            mScore++;
            mScoreView.setText(mScore + "/10");
            Toast.makeText(second.this, "correct", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(second.this, "wrong", Toast.LENGTH_SHORT).show();
        }
        index++;

        if(index > alDefinitions.size() -1){
            mQuestionView.setText("Do you want to do the quiz again?");
            mButtonChoice1.setVisibility(View.GONE);
            mButtonChoice2.setVisibility(View.GONE);
            mButtonChoice3.setVisibility(View.GONE);
            mButtonChoice4.setVisibility(View.GONE);
            btnAgain.setVisibility(View.VISIBLE);
        }
        else
            generateQuestions(index);
    }

    public void again(View view) {
        Intent mIntent = new Intent("MainActivity");
        startActivity(mIntent);
    }

}//and class ActivityTwo
