package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int flagPlayerTurn = 1,
        flag00 = 0, flag01 = 0, flag02 = 0,
        flag10 = 0, flag11 = 0, flag12 = 0,
        flag20 = 0, flag21 = 0, flag22 = 0;

    TextView turn;

    ImageView zerozero, zeroone, zerotwo,
            onezero, oneone, onetwo,
            twozero, twoone, twotwo;

    ImageView board, replay;

    public class balls{
        public String place;
        public int player;
    }

    public int chips[] = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = findViewById(R.id.board);

        replay = findViewById(R.id.replay);

        for (int i = 0;i < 9; i++){
            chips[i] = -1;
        }

        turn = findViewById(R.id.playerTurn);

        zerozero = findViewById(R.id.zerozero);
        zeroone = findViewById(R.id.zeroone);
        zerotwo = findViewById(R.id.zerotwo);
        onezero = findViewById(R.id.onezero);
        oneone = findViewById(R.id.oneone);
        onetwo = findViewById(R.id.onetwo);
        twozero = findViewById(R.id.twozero);
        twoone = findViewById(R.id.twoone);
        twotwo = findViewById(R.id.twotwo);


        changeTurn(flagPlayerTurn);
    }

    public void makeWinToast(int p){
        //Toast.makeText(getApplicationContext(), "Player " + p + " has WON!!", Toast.LENGTH_SHORT).show();
        turn.setText("Player " + p + " has WON!");

        zerozero.setAlpha(0.5f);
        zeroone.setAlpha(0.5f);
        zerotwo.setAlpha(0.5f);
        onezero.setAlpha(0.5f);
        oneone.setAlpha(0.5f);
        onetwo.setAlpha(0.5f);
        twozero.setAlpha(0.5f);
        twoone.setAlpha(0.5f);
        twotwo.setAlpha(0.5f);
        board.setAlpha(0.5f);
    }

    public void playAgain(View view){
        zerozero.setImageResource(0);
        zerozero.setBackgroundColor(0);
        zeroone.setImageResource(0);
        zeroone.setBackgroundColor(0);
        zerotwo.setImageResource(0);
        zerotwo.setBackgroundColor(0);
        onezero.setImageResource(0);
        onezero.setBackgroundColor(0);
        oneone.setImageResource(0);
        oneone.setBackgroundColor(0);
        onetwo.setImageResource(0);
        onetwo.setBackgroundColor(0);
        twozero.setImageResource(0);
        twozero.setBackgroundColor(0);
        twoone.setImageResource(0);
        twoone.setBackgroundColor(0);
        twotwo.setImageResource(0);
        twotwo.setBackgroundColor(0);

        zerozero.setAlpha(1f);
        zeroone.setAlpha(1f);
        zerotwo.setAlpha(1f);
        onezero.setAlpha(1f);
        oneone.setAlpha(1f);
        onetwo.setAlpha(1f);
        twozero.setAlpha(1f);
        twoone.setAlpha(1f);
        twotwo.setAlpha(1f);
        board.setAlpha(1f);

        flagPlayerTurn = 1;
        changeTurn(flagPlayerTurn);

        replay.setVisibility(View.GONE);

        for (int i = 0;i < 9; i++){
            chips[i] = -1;
        }

        flag00 = 0;
        flag01 = 0;
        flag02 = 0;
        flag10 = 0;
        flag11 = 0;
        flag12 = 0;
        flag20 = 0;
        flag21 = 0;
        flag22 = 0;
    }

    public void alreadyPlayedToast(){
        Toast.makeText(getApplicationContext(), "Already played!", Toast.LENGTH_SHORT).show();
    }

    public void checkWin(){
        if (chips[0] == chips[1] && chips[1] == chips[2] && chips[1] != -1){
            makeWinToast(chips[0]);
            zerozero.setBackgroundColor(Color.GREEN);
            zeroone.setBackgroundColor(Color.GREEN);
            zerotwo.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[3] == chips[4] && chips[4] == chips[5] && chips[4] != -1){
            makeWinToast(chips[3]);
            onezero.setBackgroundColor(Color.GREEN);
            oneone.setBackgroundColor(Color.GREEN);
            onetwo.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[6] == chips[7] && chips[7] == chips[8] && chips[7] != -1){
            makeWinToast(chips[6]);
            twozero.setBackgroundColor(Color.GREEN);
            twoone.setBackgroundColor(Color.GREEN);
            twotwo.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[0] == chips[4] && chips[4] == chips[8] && chips[4] != -1){
            makeWinToast(chips[0]);
            zerozero.setBackgroundColor(Color.GREEN);
            oneone.setBackgroundColor(Color.GREEN);
            twotwo.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[2] == chips[4] && chips[2] == chips[6] && chips[2] != -1){
            makeWinToast(chips[2]);
            zerotwo.setBackgroundColor(Color.GREEN);
            oneone.setBackgroundColor(Color.GREEN);
            twozero.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[0] == chips[3] && chips[0] == chips[6] && chips[0] != -1){
            makeWinToast(chips[0]);
            zerozero.setBackgroundColor(Color.GREEN);
            onezero.setBackgroundColor(Color.GREEN);
            twozero.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[1] == chips[4] && chips[1] == chips[7] && chips[1] != -1){
            makeWinToast(chips[1]);
            zeroone.setBackgroundColor(Color.GREEN);
            oneone.setBackgroundColor(Color.GREEN);
            twoone.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
        if (chips[2] == chips[5] && chips[5] == chips[8] && chips[8] != -1){
            makeWinToast(chips[2]);
            zerotwo.setBackgroundColor(Color.GREEN);
            onetwo.setBackgroundColor(Color.GREEN);
            twotwo.setBackgroundColor(Color.GREEN);
            replay.setVisibility(View.VISIBLE);
        }
    }

    public void changeTurn(int p){
        if (p == 1){
            turn.setText("Player 1 turn");
            flagPlayerTurn = p;
        } else {
            turn.setText("Player 2 turn");
            flagPlayerTurn = p;
        }
    }

    public void zerozero(View view){
        if (flag00 == 0) {
//            Toast.makeText(getApplicationContext(), "zero zero pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                zerozero.setImageResource(R.drawable.redchip);
            else
                zerozero.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            zerozero.setScaleType(ImageView.ScaleType.FIT_CENTER);
            zerozero.setTranslationY(-1000f);
            zerozero.animate().translationYBy(1000f).setDuration(300);
            chips[0] = flagPlayerTurn;
            flag00 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void zeroone(View view){
        if (flag01 == 0) {
//            Toast.makeText(getApplicationContext(), "zero one pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                zeroone.setImageResource(R.drawable.redchip);
            else
                zeroone.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            zeroone.setScaleType(ImageView.ScaleType.FIT_CENTER);
            zeroone.setTranslationY(-1000f);
            zeroone.animate().translationYBy(1000f).setDuration(300);
            chips[1] = flagPlayerTurn;
            flag01 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void zerotwo(View view){
        if (flag02 == 0) {
//            Toast.makeText(getApplicationContext(), "zero two pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                zerotwo.setImageResource(R.drawable.redchip);
            else
                zerotwo.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            zerotwo.setScaleType(ImageView.ScaleType.FIT_CENTER);
            zerotwo.setTranslationY(-1000f);
            zerotwo.animate().translationYBy(1000f).setDuration(300);
            chips[2] = flagPlayerTurn;
            flag02 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void onezero(View view){
        if (flag10 == 0) {
//            Toast.makeText(getApplicationContext(), "one zero pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                onezero.setImageResource(R.drawable.redchip);
            else
                onezero.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            onezero.setScaleType(ImageView.ScaleType.FIT_CENTER);
            onezero.setTranslationY(-1000f);
            onezero.animate().translationYBy(1000f).setDuration(300);
           chips[3] = flagPlayerTurn;
            flag10 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void oneone(View view){
        if (flag11 == 0) {
//            Toast.makeText(getApplicationContext(), "one one pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                oneone.setImageResource(R.drawable.redchip);
            else
                oneone.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            oneone.setScaleType(ImageView.ScaleType.FIT_CENTER);
            oneone.setTranslationY(-1000f);
            oneone.animate().translationYBy(1000f).setDuration(300);
           chips[4] = flagPlayerTurn;
            flag11 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void onetwo(View view){
        if (flag12 == 0) {
//            Toast.makeText(getApplicationContext(), "one two pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                onetwo.setImageResource(R.drawable.redchip);
            else
                onetwo.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            onetwo.setScaleType(ImageView.ScaleType.FIT_CENTER);
            onetwo.setTranslationY(-1000f);
            onetwo.animate().translationYBy(1000f).setDuration(300);
            chips[5] = flagPlayerTurn;
            flag12 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void twozero(View view){
        if (flag20 == 0) {
//            Toast.makeText(getApplicationContext(), "two zero pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                twozero.setImageResource(R.drawable.redchip);
            else
                twozero.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            twozero.setScaleType(ImageView.ScaleType.FIT_CENTER);
            twozero.setTranslationY(-1000f);
            twozero.animate().translationYBy(1000f).setDuration(300);
            chips[6] = flagPlayerTurn;
            flag20 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void twoone(View view){
        if (flag21 == 0) {
//            Toast.makeText(getApplicationContext(), "two one pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                twoone.setImageResource(R.drawable.redchip);
            else
                twoone.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            twoone.setScaleType(ImageView.ScaleType.FIT_CENTER);
            twoone.setTranslationY(-1000f);
            twoone.animate().translationYBy(1000f).setDuration(300);
            chips[7] = flagPlayerTurn;
            flag21 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

    public void twotwo(View view){
        if (flag22 == 0) {
//            Toast.makeText(getApplicationContext(), "two two pressed", Toast.LENGTH_SHORT).show();
            if (flagPlayerTurn == 1)
                twotwo.setImageResource(R.drawable.redchip);
            else
                twotwo.setImageResource(R.drawable.yellowchip);
//            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(800, 130);
//            zerozero.setLayoutParams(parms);
            twotwo.setScaleType(ImageView.ScaleType.FIT_CENTER);
            twotwo.setTranslationY(-1000f);
            twotwo.animate().translationYBy(1000f).setDuration(300);
            chips[8] = flagPlayerTurn;
            flag22 = 1;
            if (flagPlayerTurn == 1){
                changeTurn(2);
            } else {
                changeTurn(1);
            }
            checkWin();
        } else {
            alreadyPlayedToast();
        }
    }

}