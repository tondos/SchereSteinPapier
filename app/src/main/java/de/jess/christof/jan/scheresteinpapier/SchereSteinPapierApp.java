package de.jess.christof.jan.scheresteinpapier;

import android.app.Application;
import android.content.Context;

public class SchereSteinPapierApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}

