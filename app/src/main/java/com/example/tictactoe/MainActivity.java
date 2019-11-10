package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.tictactoe.R.*;

public class MainActivity extends AppCompatActivity {

    private static int turn = 1;
    private static ArrayList<Integer> player1 = new ArrayList<Integer>();
    private static ArrayList<Integer> player2 = new ArrayList<Integer>();
    private static int player1Wins = 0;
    private static int player2Wins = 0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        b1 = (Button) findViewById(id.button1);
        b2 = (Button) findViewById(id.button2);
        b3 = (Button) findViewById(id.button3);
        b4 = (Button) findViewById(id.button4);
        b5 = (Button) findViewById(id.button5);
        b6 = (Button) findViewById(id.button6);
        b7 = (Button) findViewById(id.button7);
        b8 = (Button) findViewById(id.button8);
        b9 = (Button) findViewById(id.button9);
        score = (TextView) findViewById(id.textView);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            score.setText(extras.getString("result"));


    }

    private void changeBackground(Button b, int position) {
        if(turn == 1) {
            player1.add(position);
            b.setBackgroundResource(R.raw.x);
            turn = 2;
        }
        else {
            player2.add(position);
            b.setBackgroundResource(R.raw.o);
            turn = 1;
        }
        b.setClickable(false);
    }

    public void newGame(View view) {
        player1Wins = 0;
        player2Wins = 0;
        newRound();
    }

    public void restart(View view) {
        newRound();
    }

    private void newRound() {
        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);
        b5.setClickable(true);
        b6.setClickable(true);
        b7.setClickable(true);
        b8.setClickable(true);
        b9.setClickable(true);
        player1.clear();
        player2.clear();
        Intent round = new Intent(this, MainActivity.class);
        round.putExtra("result", player1Wins + ":" + player2Wins);
        startActivity(round);
        finish();
    }

    public void clickMe(View view) {
        switch (view.getId()) {
            case id.button1:
                changeBackground(b1, 1);
                break;
            case id.button2:
                changeBackground(b2, 2);
                break;
            case id.button3:
                changeBackground(b3,3);
                break;
            case id.button4:
                changeBackground(b4,4);
                break;
            case id.button5:
                changeBackground(b5,5);
                break;
            case id.button6:
                changeBackground(b6,6);
                break;
            case id.button7:
                changeBackground(b7,7);
                break;
            case id.button8:
                changeBackground(b8,8);
                break;
            case id.button9:
                changeBackground(b9,9);
                break;
            default:
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
        }

        if((player1.contains(1) && player1.contains(2) && player1.contains(3)) ||
                (player1.contains(4) && player1.contains(5) && player1.contains(6)) ||
                (player1.contains(7) && player1.contains(8) && player1.contains(9)) ||
                (player1.contains(1) && player1.contains(4) && player1.contains(7)) ||
                (player1.contains(2) && player1.contains(5) && player1.contains(8)) ||
                (player1.contains(3) && player1.contains(6) && player1.contains(9)) ||
                (player1.contains(1) && player1.contains(5) && player1.contains(9)) ||
                (player1.contains(7) && player1.contains(5) && player1.contains(3))) {
            player1Wins ++;
            Toast.makeText(this,"X wins", Toast.LENGTH_SHORT).show();
            newRound();
        } else if ((player2.contains(1) && player2.contains(2) && player2.contains(3)) ||
                (player2.contains(4) && player2.contains(5) && player2.contains(6)) ||
                (player2.contains(7) && player2.contains(8) && player2.contains(9)) ||
                (player2.contains(1) && player2.contains(4) && player2.contains(7)) ||
                (player2.contains(2) && player2.contains(5) && player2.contains(8)) ||
                (player2.contains(3) && player2.contains(6) && player2.contains(9)) ||
                (player2.contains(1) && player2.contains(5) && player2.contains(9)) ||
                (player2.contains(7) && player2.contains(5) && player2.contains(3))) {
            player2Wins ++;
            Toast.makeText(this,"O wins", Toast.LENGTH_SHORT).show();
            newRound();
        }
        if( b1.isClickable() == false &&
        b2.isClickable()  == false &&
        b3.isClickable()  == false &&
        b4.isClickable()  == false &&
        b5.isClickable()  == false &&
        b6.isClickable()  == false &&
        b7.isClickable()  == false &&
        b8.isClickable()  == false &&
        b9.isClickable()  == false) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            newRound();
        }
    }
}
