package com.yyc.redemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeActivity extends AppCompatActivity {

    @InjectView(R.id.rlv)
    RecyclerView rlv;
    private List<String> list;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        initData();
//        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setLayoutManager(new GridLayoutManager(this,4));
        rlv.setAdapter(adapter = new HomeAdapter());
//        rlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        rlv.addItemDecoration(new DividerGridItemDecoration(this));
//        rlv.addItemDecoration(new GridDivider(this, 20, Color.RED));

//        rlv.addItemDecoration(new RecyclerDecoration(this, LinearLayoutManager.HORIZONTAL));

//        rlv.addItemDecoration(new Divider(this));

        adapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("aa","我点击了：" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.e("aa","我长按了：" + position);
            }
        });
    }

    private void initData() {
        list = new ArrayList<String>();
        for (int i = 'A' ; i < 'J'; i++) {
            list.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeActivity.MyViewHolder>{

        private OnItemClickLitener mOnItemClickLitener;

        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
        {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.item_rlv,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.tv.setText(list.get(position));

            //如果设置了回调，则设置点击事件
            if(mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(holder.itemView,pos);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemLongClick(holder.itemView,pos);
                        return false;
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }


}
