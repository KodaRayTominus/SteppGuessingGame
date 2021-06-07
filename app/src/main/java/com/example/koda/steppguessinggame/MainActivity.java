package com.example.koda.steppguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
implements OnClickListener {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView scoreTextView;
    private int numLeft;
    private int numRight;
    private int totalPoints;
    private Random rand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonRight = findViewById(R.id.buttonRight);
        scoreTextView = findViewById(R.id.scoreTextView);
        rand = new Random();
        totalPoints = 0;
        roll();

    }

    private void roll() {
        numLeft = rand.nextInt();
        numRight = rand.nextInt();
        buttonLeft.setText(Integer.toString(numLeft));
        buttonRight.setText(Integer.toString(numRight));
    }

    @Override
    public void onClick(View v){
        if(v == buttonLeft){
            clickButtonLeft(v);
        }
        else{
            clickButtonRight(v);
        }

        roll();
    }

    public void clickButtonLeft(View v){
        check(numLeft, numRight);
    }

    public void clickButtonRight(View v){
        check(numRight, numLeft);
    }

    public void check(int a, int b){
        if(a > b){
            totalPoints++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            totalPoints--;
            Toast.makeText(this, "Incorrect!!", Toast.LENGTH_SHORT).show();
        }

        scoreTextView.setText("Points: " + totalPoints);
    }
}
