package com.yyc.mydemo;

import android.content.Intent;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    @Override
    public void initViews() {
    }
    @Override
    public void initListeners() {
    }
    @Override
    public void initData() {
    }

    @OnClick({R.id.btn_one, R.id.activity_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(this,OneActivity.class));
                break;
            case R.id.activity_main:
                break;
        }
    }
}





















