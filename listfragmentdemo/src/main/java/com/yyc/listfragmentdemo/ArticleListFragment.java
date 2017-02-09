package com.yyc.listfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ArticleListFragment extends ListFragment {
  
    private ArrayAdapter<String> adapter;
    private FragmentManager manager;
    private FragmentTransaction transaction;
  
    public ArticleListFragment() {  
        // TODO Auto-generated constructor stub  
    }  
  
    /**  
     * 这个方法适合做一些数据初始化的工作，如连接数据库, 这段代码中setListAdapter(adapter);之所以写在这里 是因为我们现在这个类没有用到布局(onCreateView在这个项目中没用到)  
     * 如果这个项目中我们用到了动态布局，setListAdapter必须写在onCreateView中 因为只有在onCreateView方法中视图才加载，写在onCreate方法中是错的，因为这个方法 还没有加载完我们定义的视图  
     */  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        /* 创建一个数据集合 */  
        List<String> data = new ArrayList<String>();
        /* 遍历往集合中添加数据 */  
        for (int i = 0; i < 10; i++) {  
            data.add("廖泽民" + i);  
        }  
  
        /* 创建一个ArrayAdapter集合 */  
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, data);  
        /* 设置适配器 */  
        setListAdapter(adapter);  
  
        /* 获取manager */  
        manager = this.getFragmentManager();  
    }  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub  
        return super.onCreateView(inflater, container, savedInstanceState);  
    }  
  
    @Override  
    public void onPause() {  
        // TODO Auto-generated method stub  
        super.onPause();  
    }  
  
    /**  
     * ListFragment提供了一个非常方便的方法onListItemClick 我们可以对ListView中的条目进行操作  
     */  
    @Override  
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);  
  
        /* 获取条目 */  
        String item = adapter.getItem(position);  
        /* 创建事物 */  
        transaction = manager.beginTransaction();  
  
        /* 创建DetailFragment(注：这里我们可以直接new一个DetailFragment对象，因为我们之前没有通过事物将其添加到某个布局中，所以可以直接new) */  
        DetailFragment fragment = new DetailFragment();  
  
        /* 创建Bundle并添加数据 */  
        Bundle args = new Bundle();  
        args.putString("item", item);  
        /* 为fragment设置数据 */  
        fragment.setArguments(args);  
        /* 替换 */  
        transaction.replace(R.id.right, fragment, "rightFragment");  
        /* 把当前fragment添加到回退栈 */  
        transaction.addToBackStack("rightFragment");  
        /* 提交事物 */  
        transaction.commit();  
    }  
  
}  