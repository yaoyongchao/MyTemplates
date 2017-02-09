package com.yyc.listfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
  
    public DetailFragment() {  
        // TODO Auto-generated constructor stub  
    }  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub  
        super.onCreate(savedInstanceState);  
    }  
      
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*动态获取布局*/  
        View view = inflater.inflate(R.layout.detail, null);  
        /*从动态布局中获取TextView*/  
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        /*从ArticleListFragment中获取传递过来的参数*/  
        Bundle bundle = this.getArguments();  
          
        textView.setText(bundle.getString("item"));  
          
        return view;  
    }  
      
    @Override  
    public void onPause() {  
        // TODO Auto-generated method stub  
        super.onPause();  
    }  
} 