package com.example.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Result2Activity extends AppCompatActivity {

    MediaPlayer player;
    TextView tv4, tv5, tv6;
    Button btnRestart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        tv4 = findViewById(R.id.correct2);
        tv5 = findViewById(R.id.wrong2);
        tv6 = findViewById(R.id.score2);
        btnRestart2 = findViewById(R.id.btnMenu2);

        StringBuffer sb4 = new StringBuffer();
        sb4.append("Poprawne odpowiedzi: " + Questions2Activity.correct2 + "\n");
        StringBuffer sb5 = new StringBuffer();
        sb5.append("Złe odpowiedzi: " + Questions2Activity.wrong2 + "\n");
        StringBuffer sb6 = new StringBuffer();
        sb6.append("Wynik: " + Questions2Activity.correct2 + "\n");

        tv4.setText(sb4);
        tv5.setText(sb5);
        tv6.setText(sb6);

        if(Questions2Activity.correct2 >= 6){
            player = MediaPlayer.create(this, R.raw.win);
            player.start();
        }
        else {
            player = MediaPlayer.create(this, R.raw.fail);
            player.start();
        }

        Questions2Activity.correct2 = 0;
        Questions2Activity.wrong2 = 0;



        btnRestart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
