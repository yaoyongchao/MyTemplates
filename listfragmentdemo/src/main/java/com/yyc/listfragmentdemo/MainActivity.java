package com.yyc.listfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity {

    private Button button;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*获取按钮*/
        button = (Button) this.findViewById(R.id.button1);
        /*获取manager*/
        manager = this.getSupportFragmentManager();
        /*设置按钮的监听事件*/
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*创建事物*/
                transaction = manager.beginTransaction();
                /*创建ArticleListFragment*/
                ArticleListFragment fragment = new ArticleListFragment();
                /*添加*/
                transaction.add(R.id.center, fragment, "article");
                /*提交事物*/
                transaction.commit();
            }
        });

    }


}