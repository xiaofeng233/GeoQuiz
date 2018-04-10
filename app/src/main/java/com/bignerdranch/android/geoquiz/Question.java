package com.bignerdranch.android.geoquiz;

/**
 * Created by 13178 on 2018-3-21.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId ,boolean answerTrue){
        mTextResId=textResId;
        mAnswerTrue=answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
