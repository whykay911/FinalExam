package com.example.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "quizdb";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "quiz";

    private static final String ID_COL = "id";
    private static final String QUESTIONNO_COL = "questionNo";

    private static final String QUESTION_COL = "question";
    private static final String ANSWER_COL = "answer";

    private static final String OPTION1_COL = "option1";

    private static final String OPTION2_COL = "option2";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTIONNO_COL + " TEXT,"
                + QUESTION_COL + " TEXT,"
                + ANSWER_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewUser(String questionNo, String question, String answer) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(QUESTIONNO_COL, questionNo);
        values.put(QUESTION_COL, question);
        values.put(ANSWER_COL, answer);

    db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<QuizModal> readQuiz() {
       SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursorQuiz = db.rawQuery("SELECT * FROM " + TABLE_NAME+" ORDER BY RANDOM() LIMIT 3",null);
       ArrayList<QuizModal> QuizModalArrayList = new ArrayList<>();

        int number = cursorQuiz.getCount();
        if (number<=0){
            QuizModalArrayList.add(new QuizModal("", "",
                    ""
                    ));
            return QuizModalArrayList;
        }
        else{
            if (cursorQuiz.moveToFirst()) {
                do {

                    QuizModalArrayList.add(new QuizModal(cursorQuiz.getString(1),
                            cursorQuiz.getString(2),
                            cursorQuiz.getString(3)));
                } while (cursorQuiz.moveToNext());
            }
            cursorQuiz.close();
            return QuizModalArrayList;}
    }

    public void updateQuestion(String questionNo, String question, String answer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTIONNO_COL, questionNo);
        values.put(QUESTION_COL, question);
        values.put(ANSWER_COL, answer);

        db.update(TABLE_NAME, values, "questionNo=?", new String[]{questionNo});
        db.close();
    }

    public void deleteUser(String id) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "questionNo=?", new String[]{id});
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}




