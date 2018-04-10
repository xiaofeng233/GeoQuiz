package com.bignerdranch.android.geoquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG ="QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTruebutton;
    private Button mFalsebutton;
    private Button mPrevbutton;
    private Button mNextbutton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.qusetion_oceans,true),
            new Question(R.string.qusetion_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState!=null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.queston_text_view);
        //int queston = mQuestionBank[mCurrentIndex].getTextResId();
        //mQuestionTextView.setText(queston);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1) % mQuestionBank.length;
                //int question = mQuestionBank[mCurrentIndex].getTextResId();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        mTruebutton = (Button) findViewById(R.id.true_button);
        mTruebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast toast=Toast.makeText(QuizActivity.this,
                //        R.string.correct_toast,
                //        Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.TOP,0,170);
                //toast.show();
                //dose nothing yet ,but soon.
                checkAnswer(true);
            }
        });
        mFalsebutton = (Button) findViewById(R.id.false_button);
        mFalsebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*Toast toast=Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,170);
                toast.show();
                //dose nothing yet ,but soon.*/
                checkAnswer(false);
            }
        });
        mPrevbutton =(Button) findViewById(R.id.prev_button);
        mPrevbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(Math.abs(mCurrentIndex-1)) % mQuestionBank.length;
                //int question = mQuestionBank[mCurrentIndex].getTextResId();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        mNextbutton =(Button) findViewById(R.id.next_button);
        mNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1) % mQuestionBank.length;
                //int question = mQuestionBank[mCurrentIndex].getTextResId();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }



    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(userPressedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        } else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show();
    }
}
