package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME="com.example.tictactoe.extra.NAME";
    boolean gameactive=true;

    int activeplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    //state meaning 0=x,1=o,2=null

    int [][] winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};



    public void playertap(View view){

        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset();
        }

        if(gamestate[tappedImage]==2 && gameactive){
            gamestate[tappedImage]=activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer==0){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O turn - Tap to play");
            }
            else {
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);


        }


        //checking for winning
        for(int[]winposition: winposition){
             if(gamestate[winposition[0]]==gamestate[winposition[1]] &&gamestate[winposition[1]]==gamestate[winposition[2]]&&gamestate[winposition[0]]!=2) {
                 //who is won
                 String winnerstr;
                 gameactive=false;
                 if (gamestate[winposition[0]] == 0) {
                     winnerstr = "X has won";
                     Intent i =new Intent(this,MainActivity2.class);
                     i.putExtra(EXTRA_NAME,winnerstr);
                     startActivity(i);

                 } else {
                     winnerstr = "O has won";
                     Intent i =new Intent(this,MainActivity2.class);
                     i.putExtra(EXTRA_NAME,winnerstr);
                     startActivity(i);
                 }
                 TextView status = findViewById(R.id.status);
                 status.setText(winnerstr);
             }
         }
    }
    public void gamereset(){
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}