package com.yyc.mytemplate.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;

import com.yyc.mytemplate.util.ActivityManager;


/**
 * @author: yaoyongchao
 * @date: 2016/1/15 16:02
 * @description: The Activity base class;
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    protected int mScreenWidth;
    protected int mScreenHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The Activity is added to the stack
        ActivityManager.getInstance().addActivity(this);

        //public attribute;
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;

        //  Order process
        setContentView();
        initViews();
        initListeners();
        initData();
    }

    public abstract void setContentView();
    public abstract void initViews();
    public abstract void initListeners();
    public abstract void initData();

    public abstract void onClick(View v);
   /* protected <T extends View> T generateFindViewById(int id) {
        //return返回view时,加上泛型T
        return (T) findViewById(id);
    }*/
    protected <T extends View> T findView(int resId) {
        return (T)findViewById(resId);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //The end of the Activity and removed from the stack
        ActivityManager.getInstance().finishActivity(this);
    }
}
