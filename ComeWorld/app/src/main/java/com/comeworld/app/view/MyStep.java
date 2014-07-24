package com.comeworld.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comeworld.app.R;

/**
 * Created by come on 03/06/14.
 */
public class MyStep extends LinearLayout {
    private TextView mNumber;
    private EditText mEdit;

    public MyStep(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_step, this);
        mNumber = (TextView) findViewById(R.id.number);
        mEdit = (EditText) findViewById(R.id.edit);
    }

    public void setNumber(String number) {
        mNumber.setText(number);
    }

    public EditText getEditText() {
        return mEdit;
    }

}