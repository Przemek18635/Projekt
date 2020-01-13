package com.example.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {

    MediaPlayer player;
    TextView tv, tv2, tv3;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.correct);
        tv2 = findViewById(R.id.wrong);
        tv3 = findViewById(R.id.score);
        btnRestart = findViewById(R.id.btnMenu);

        StringBuffer sb = new StringBuffer();
        sb.append("Poprawne odpowiedzi: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Złe odpowiedzi: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Wynik: " + QuestionsActivity.correct + "\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        if(QuestionsActivity.correct >= 6){
            player = MediaPlayer.create(this, R.raw.win);
            player.start();
        }
        else {
            player = MediaPlayer.create(this, R.raw.fail);
            player.start();
        }

        QuestionsActivity.correct = 0;
        QuestionsActivity.wrong = 0;

        btnRestart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
