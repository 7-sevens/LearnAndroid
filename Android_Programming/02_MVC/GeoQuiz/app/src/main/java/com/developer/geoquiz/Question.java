package com.developer.geoquiz;

/**
 * blog：http://www.developer1024.com/
 * 微信公众号：开发者小黑屋
 * ----------------------------------
 * brief : Question类
 * author: 7-sevens
 * date  : 2017/5/15.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
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
