package com.comeworld.app.helper;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by come on 24/06/14.
 */
public class TextHelper {
    public static boolean isOk(String... param) {
        boolean ok = true;
        for (String e : param) {
            if (TextUtils.isEmpty(e) || e == null || TextUtils.equals(e, "null"))
                ok = false;
            Log.i("LOG", "" + e);
        }
        return ok;
    }
}
