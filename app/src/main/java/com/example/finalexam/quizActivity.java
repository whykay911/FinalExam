package com.example.finalexam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class quizActivity extends AppCompatActivity {
    private int answer;
    private int count = 0;
    private DBHandler dbHandler;
    private ArrayList<QuizModal> ourData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        dbHandler = new DBHandler(quizActivity.this);
        ourData = dbHandler.readQuiz();

        Button prev = (Button) findViewById(R.id.previous);
        Button next = (Button) findViewById(R.id.next);
        
        if(count<ourData.size()) {
            count = 0;
            String questionNo = ourData.get(count).getQuestionNo().toString();
            String question = ourData.get(count).getQuestion().toString();
            String answer = ourData.get(count).getAnswer().toString();

            TextView questionNoField = (TextView) findViewById(R.id.questionNo);
            TextView questionField = (TextView) findViewById(R.id.question);

            questionNoField.setText(questionNo);
            questionField.setText(question);
          
        }
        
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<ourData.size()) {
                    count++;
                    String questionNo = ourData.get(count).getQuestionNo().toString();
                    String question = ourData.get(count).getQuestion().toString();
                    String answer = ourData.get(count).getAnswer().toString();

                    TextView questionNoField = (TextView) findViewById(R.id.questionNo);
                    TextView questionField = (TextView) findViewById(R.id.question);

                    questionNoField.setText(questionNo);
                    questionField.setText(question);

                }else{
                    Toast.makeText(quizActivity.this, "No more Questions", Toast.LENGTH_SHORT).show();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<ourData.size()) {
                    count--;
                    String questionNo = ourData.get(count).getQuestionNo().toString();
                    String question = ourData.get(count).getQuestion().toString();
                    String answer = ourData.get(count).getAnswer().toString();

                    TextView questionNoField = (TextView) findViewById(R.id.questionNo);
                    TextView questionField = (TextView) findViewById(R.id.question);

                    questionNoField.setText(questionNo);
                    questionField.setText(question);

                }else{
                    Toast.makeText(quizActivity.this, "No more Questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
   }
}