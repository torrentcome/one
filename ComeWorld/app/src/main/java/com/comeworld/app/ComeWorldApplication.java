package com.comeworld.app;

import android.app.Application;

import com.comeworld.app.database.DatabaseHelper;

/**
 * Created by come on 24/06/14.
 */
public class ComeWorldApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // DATABASE
        DatabaseHelper.getInstance(this);
    }
}
