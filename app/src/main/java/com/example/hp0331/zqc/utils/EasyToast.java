package com.example.hp0331.zqc.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by hp0331 on 2017/6/16.
 */

public  enum EasyToast {
    INSTANCE;

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;

    EasyToast() {}

    Toast toast = null;

    public void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public synchronized void show(Activity activity, int textId) {
        show(activity, textId, LENGTH_SHORT);
    }

    public synchronized void show(Activity activity, int textId, int duration) {
        cancel();

        Toast.makeText(activity, textId, duration).show();
    }
    public synchronized void show(Activity activity, String string, int duration) {
        cancel();

        Toast.makeText(activity, string, duration).show();
    }
}
