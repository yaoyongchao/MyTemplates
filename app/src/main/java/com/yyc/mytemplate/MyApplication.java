package com.yyc.mytemplate;

import android.app.Application;
import android.util.Log;

import com.yyc.mytemplate.util.CrashHandler;


/**
 * @author: Administrator
 * @date: 2016/1/7 15:52
 * @description:
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        // 异常处理，不需要处理时注释掉这句即可！
        CrashHandler.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        Log.i(TAG, "onTerminate: The end of the program.");
        super.onTerminate();
        Log.i(TAG, "onTerminate: The end of the program.");
    }
}
















