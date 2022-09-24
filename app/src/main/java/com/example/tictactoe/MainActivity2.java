package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity  {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.textView);
        Intent i=getIntent();
        String name=i.getStringExtra(MainActivity.EXTRA_NAME);
        textView.setText(name);


    }
    public void btn(View view){
        Intent i=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(i);
    }



}