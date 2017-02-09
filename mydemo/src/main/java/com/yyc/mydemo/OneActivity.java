package com.yyc.mydemo;

import android.content.Intent;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OneActivity extends BaseActivity {

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_one);
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

    @Override
    public void onClick(View v) {

    }

    @OnClick(R.id.btn)
    public void onClick() {
        startActivity(new Intent(this,TwoActivity.class));
    }
}















