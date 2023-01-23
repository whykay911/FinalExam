package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class createActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void update(View v){

        dbHandler = new DBHandler(createActivity.this);
        EditText questionNo = (EditText) findViewById(R.id.questionNo);
        EditText question = (EditText) findViewById(R.id.question);
        EditText answer = (EditText) findViewById(R.id.answer);


        if (questionNo.getText().toString().isEmpty() && question.getText().toString().isEmpty() && answer.getText().toString().isEmpty() ) {
            Toast.makeText(createActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }

        // on below line we are calling a method to add new
        // course to sqlite data and pass all our values to it.
        dbHandler.updateQuestion(questionNo.getText().toString(), question.getText().toString(), answer.getText().toString());

        // after adding the data we are displaying a toast message.

        Toast.makeText(createActivity.this, "Question has been updated.", Toast.LENGTH_SHORT).show();
        questionNo.setText("");
        question.setText("");
        answer.setText("");
    }

    public void createQuiz(View v){

        dbHandler = new DBHandler(createActivity.this);
        EditText questionNo = (EditText) findViewById(R.id.questionNo);
        EditText question = (EditText) findViewById(R.id.question);
        EditText answer = (EditText) findViewById(R.id.answer);


        if (questionNo.getText().toString().isEmpty() && question.getText().toString().isEmpty() && answer.getText().toString().isEmpty() ) {
            Toast.makeText(createActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }

        // on below line we are calling a method to add new
        // course to sqlite data and pass all our values to it.
        dbHandler.addNewUser(questionNo.getText().toString(), question.getText().toString(), answer.getText().toString());

        // after adding the data we are displaying a toast message.

        Toast.makeText(createActivity.this, "Question has been added.", Toast.LENGTH_SHORT).show();
        questionNo.setText("");
        question.setText("");
        answer.setText("");
    }

    public void delete(View v){
        dbHandler = new DBHandler(createActivity.this);
        EditText questionNo = (EditText) findViewById(R.id.questionNo);

        dbHandler.deleteUser(questionNo.getText().toString());
        Toast.makeText(createActivity.this, "Question has been deleted.", Toast.LENGTH_SHORT).show();

    }

    public void submit(View v){
        Intent myIntent = new Intent(this, quizActivity.class);

        startActivity(myIntent);
    }

    public void preview(View v){
        Intent myIntent = new Intent(this, quizActivity.class);

        startActivity(myIntent);
    }
    public void done(View v){
        Log.d("new mesage","go back");
        finish();
    }
}