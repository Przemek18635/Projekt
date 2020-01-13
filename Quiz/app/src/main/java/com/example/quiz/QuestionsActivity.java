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

public class QuestionsActivity extends AppCompatActivity {

    TextView questionText;
    Button nextButton, quitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "3 do sześcianu to:",
            "a = -2, b = -3, c = 4; Rozwiąż równanie: a - b - c",
            "Rzucamy 2 razy monetą. Jakie jest prawdopodobieństwo, że wypadnie orzeł?",
            "Ile wynosi pierwiastek sześcienny ze 125?",
            "5^(-1) wynosi:",
            "Rozwiązaniem równania x^2 - 3x = 0 jest:",
            "Jaki jest setny element ciągu 2n - 1?",
            "Ile mililitrów znajduje się w 2 i 1/4 litra?",
            "(2+3)(5-6)*3+2=",
            "Jeśli zsumujesz pierwiastek kwadratowy 9 z kwadratem liczby 12, otrzymasz:"
                         };
    String answers[] = {"27","-3","1/4","5","0,2","x = 3 lub x = 0","199","2250","-13","147"};
    String opt[] = {
            "27","9","6","81",
            "5","-9","-3","-1",
            "1/2","1/3","3/4","1/4",
            "4","15","5","25",
            "0,2","-1/5","0","-5",
            "x = 2","x = 3 lub x = 0","x = 1/3","x = 9",
            "201","199","100","49",
            "2050","22500","2500","2250",
            "30","-13","-30","17",
            "124","147","3 + pierwiastek z 12","228"
                   };
    int flag = 0;
    public static int marks = 0,correct = 0,wrong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = findViewById(R.id.textView4);
        TextView textView = findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        if (name.trim().equals(""))
            textView.setText("Cześć");

        else textView.setText("Cześć " + name);

        nextButton = findViewById(R.id.next);
        quitButton = findViewById(R.id.quit);
        questionText = findViewById(R.id.questionText);

        radio_g = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        questionText.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Wybierz jedną odpowiedź", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton odp = findViewById(radio_g.getCheckedRadioButtonId());
                String odpText = odp.getText().toString();

                if(odpText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Źle", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    questionText.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}