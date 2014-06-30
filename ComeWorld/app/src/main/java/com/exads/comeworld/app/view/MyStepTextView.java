package com.exads.comeworld.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exads.comeworld.app.R;

/**
 * Created by come on 03/06/14.
 */
public class MyStepTextView extends LinearLayout {
    private TextView mNumber;
    private TextView mEdit;

    public MyStepTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_step_textview, this);
        mNumber = (TextView) findViewById(R.id.number);
        mEdit = (TextView) findViewById(R.id.edit);
    }

    public void setNumber(String number) {
        mNumber.setText(number);
    }

    public TextView getEditText() {
        return mEdit;
    }

}