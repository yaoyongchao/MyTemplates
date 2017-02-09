package com.yyc.redemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    /**
     * @author yaoyongchao
     * @time 2017/2/7 15:18
     * @description 从0开始学习RecyclerView
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn, R.id.two})
    public void onClick(View view) {
        switch (view.getId()) {
       case R.id.btn:
                startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.two:
                sortStudent();
                break;
        }
    }

    public void sortStudent() {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("张三1",10,90));
        list.add(new Student("张三2",14,110));
        list.add(new Student("张三3",8,700));
        list.add(new Student("张三4",6,300));

        Collections.sort(list);

        for(Student s : list) {
            if(s.age == 10) {
                s.age = 12;
            }
            Log.e("aa","name:" + s.name + "--age:" + s.age + "---weight" + s.wight);
        }

        Collections.sort(list,new AnimalsComparator());

        for(Student s : list) {
            Log.e("aa","name:" + s.name + "--age:" + s.age + "---weight" + s.wight);
        }

        String s = "123456";
        Log.e("aa","s:" + s.substring(1,s.length()-1));
    }
    class AnimalsComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.wight > o2.wight)
                return 1;
            if (o1.wight < o2.wight)
                return -1;
            else
                return 0;
        }
    }
}
