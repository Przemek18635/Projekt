package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Questions2Activity extends AppCompatActivity {

    TextView questionText2;
    Button nextButton2, quitButton2;
    RadioGroup radio_g1;
    RadioButton rb5,rb6,rb7,rb8;

    String questions2[] = {
            "Jak nazywa się część zdania określająca rzeczownik?",
            "Co oznacza wyraz hermafrodyta?",
            "Kto jest autorem Ferdydurke?",
            "Która para wyrazów jest przykładem homofonów?",
            "Z ilu głosek składa się wyraz mammografia?",
            "Wyraz 'wesprzeć' w 1. osobie liczby pojedynczej czasu przyszłęgo brzmi:",
            "Tematem przewodnim której powieści jest miłość Justyny Orzelskiej i Jana Bohatyrowicza?",
            "Na którą sylabę od końca pada akcent w wyrazie pedagogika?",
            "Tumany pyłu, kurzu czy śniegu możemy określić wyrazem k__awa. Wybierz odpowiednią konfigurację liter.",
            "Stopień wyższy od wyrazu dobry to:"
    };
    String answers2[] = {"przydawka","osobę posiadającą narządy płciowe obu płci","Witold Gombrowicz","Bóg, buk","10","wesprę","Nad Niemnem","3","u, rz","lepszy"};
    String opt2[] = {
            "okolicznik","orzeczenie","podmiot","przydawka",
            "piękną i wykształconą kurtyzanę","osobę posiadającą narządy płciowe obu płci","kłótliwą kobietę","kobietę niezwykłej, delikatnej urody",
            "Jerzy Putrament","Witold Gombrowicz","Władysław Broniewski","Stanisław Ignacy Witkiewicz",
            "Bóg, buk","dobry, zły","przedmiot, rzecz","Golf(auto), golf(gra)",
            "4","5","11","10",
            "wesprzesz się","wsparłem","wesprę","wesprzemy",
            "Lalka","Między ustami a brzegiem pucharu","Nad Niemnem","Noce i dnie",
            "2","3","1","5",
            "ó, rz","u, ż","ó, ż","u, rz",
            "dobre","zły","lepszy","najlepszy"
    };

    int flag2 = 0;
    public static int marks2 = 0,correct2 = 0,wrong2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

        final TextView score2 = findViewById(R.id.textView5);
        //TextView textView2 = findViewById(R.id.dispName2);
        //Intent intent2 = getIntent();
        //String name2 = intent2.getStringExtra("name");

        //if (name2.trim().equals(""))
         //  textView2.setText("Cześć");
        //else textView2.setText("Cześć " + name2);

        nextButton2 = findViewById(R.id.next2);
        quitButton2 = findViewById(R.id.quit2);
        questionText2 = findViewById(R.id.questionText2);

        radio_g1 = findViewById(R.id.radioGroup1);
        rb5 = findViewById(R.id.radioButton5);
        rb6 = findViewById(R.id.radioButton6);
        rb7 = findViewById(R.id.radioButton7);
        rb8 = findViewById(R.id.radioButton8);
        questionText2.setText(questions2[flag2]);
        rb5.setText(opt2[0]);
        rb6.setText(opt2[1]);
        rb7.setText(opt2[2]);
        rb8.setText(opt2[3]);

        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g1.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Wybierz jedną odpowiedź", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton odp = findViewById(radio_g1.getCheckedRadioButtonId());
                String odpText = odp.getText().toString();

                if(odpText.equals(answers2[flag2])) {
                    correct2++;
                    Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong2++;
                    Toast.makeText(getApplicationContext(), "Źle", Toast.LENGTH_SHORT).show();
                }

                flag2++;

                if (score2 != null)
                    score2.setText(""+correct2);

                if(flag2 < questions2.length)
                {
                    questionText2.setText(questions2[flag2]);
                    rb5.setText(opt2[flag2*4]);
                    rb6.setText(opt2[flag2*4 +1]);
                    rb7.setText(opt2[flag2*4 +2]);
                    rb8.setText(opt2[flag2*4 +3]);
                }
                else
                {
                    marks2 = correct2;
                    Intent in = new Intent(getApplicationContext(),Result2Activity.class);
                    startActivity(in);
                }
                radio_g1.clearCheck();
            }
        });

        quitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(getApplicationContext(),Result2Activity.class);
                startActivity(in2);
            }
        });
    }
}
